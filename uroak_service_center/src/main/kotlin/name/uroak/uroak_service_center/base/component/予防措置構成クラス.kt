package name.uroak.uroak_service_center.base.component

import name.uroak.uroak_service_center.shared.base.ret.システムエラー系戻り値クラス
import name.uroak.uroak_service_center.shared.base.util.JSONフィールド名言語一覧
import name.uroak.uroak_service_center.shared.constants.message.メッセージID一覧
import name.uroak.uroak_service_center.shared.util.log.ログ
import name.uroak.uroak_service_center.shared.util.tool.文字列道具箱
import name.uroak.uroak_service_center.shared.util.tool.道具箱
import name.uroak.uroak_service_center.sysad.repository.ユーザ認証リポジトリ
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.security.authentication.AccountStatusUserDetailsChecker
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken
import org.springframework.stereotype.Service
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 *
 */
enum class UroakHTTPヘッダー {
    認証キー("X-UROAK-AUTHKEYSTR"),
    利用者名("X-UROAK_SVCUSER"),
    利用者パスワード("X-UROAK_SVCPASSWD");

    /***/
    val ヘッダー名: String

    /**
     *
     */
    constructor(ヘッダー名: String) {
        this.ヘッダー名 = ヘッダー名
    }
}

/**認証用ユーザ名、パスワードが未設定であることを示す文字列*/
internal const val 無効文字列 = "%@@ 無効 @@%"

/**
 *
 */
internal class 利用者認証情報クラス {
    val 利用者名: String
    val 利用者パスワード: String

    constructor() {
        this.利用者名 = 無効文字列
        this.利用者パスワード = 無効文字列
    }

    constructor(利用者名: String, 利用者パスワード: String) {
        this.利用者名 =
            if (!文字列道具箱.空白文字列か(利用者名))
                利用者名
            else
                無効文字列
        this.利用者パスワード =
            if (!文字列道具箱.空白文字列か(利用者パスワード))
                利用者パスワード
            else
                無効文字列
    }

    fun 無効か(): Boolean = (利用者名 == 無効文字列 || 利用者パスワード == 無効文字列)
}

/**
 *
 */
internal fun 文字列が無効か(文字列: String?): Boolean {
    return if (文字列道具箱.空白文字列か(文字列))
        true
    else
        文字列 == 無効文字列
}

/**
 *
 */
internal class 事前承認用濾過器クラス : AbstractPreAuthenticatedProcessingFilter() {
    /**
     * X-UROAK_SVCUSERヘッダの値とX-UROAK_SVCPASSWDヘッダーの値をprincipalとして返す
     */
    override fun getPreAuthenticatedPrincipal(リクエスト: HttpServletRequest): Any {
        try {
            return 利用者認証情報クラス(
                利用者名 = リクエスト.getHeader(UroakHTTPヘッダー.利用者名.ヘッダー名),
                利用者パスワード = リクエスト.getHeader(UroakHTTPヘッダー.利用者パスワード.ヘッダー名)
            )
        } catch (エラー: Throwable) {
            ログ.エラーログを出力する(this.javaClass, エラー, メッセージID一覧.CMN_E_0002, "事前承認用フィルターの処理中に例外が発生しました。")
        }

        return 利用者認証情報クラス()
    }

    /**
     * X-UROAK-AUTHKEYSTRヘッダの値をcredentialとして返す
     */
    override fun getPreAuthenticatedCredentials(リクエスト: HttpServletRequest): Any {
        try {
            val 認証キー = リクエスト.getHeader(UroakHTTPヘッダー.認証キー.ヘッダー名)
            return if (!文字列道具箱.空白文字列か(認証キー)) 認証キー else 無効文字列
        } catch (エラー: Throwable) {
            ログ.エラーログを出力する(this.javaClass, エラー, メッセージID一覧.CMN_E_0002, "事前承認用フィルターの処理中に例外が発生しました。")
        }

        return 無効文字列
    }
}

/**
 *
 */
@Service
internal class 認証対象利用者詳細サービスクラス : AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

    @Autowired
    private lateinit var ユーザ認証: ユーザ認証リポジトリ

    /**
     *
     */
    @Throws(UsernameNotFoundException::class)
    override fun loadUserDetails(トークン: PreAuthenticatedAuthenticationToken): UserDetails {

        try {
            val 認証キー = トークン.credentials as String
            val 利用者認証情報 = トークン.principal as 利用者認証情報クラス

            if (認証キー == 無効文字列) {
                throw UsernameNotFoundException("認証キーがありません。")
            } else if (利用者認証情報.無効か()) {
                throw UsernameNotFoundException("利用者名、あるいは利用者パスワードが未設定です。")
            }

            if (ユーザ認証.認証ユーザとして登録されているかチェックする(利用者認証情報.利用者名, 利用者認証情報.利用者パスワード) == 0) {
                throw UsernameNotFoundException(
                    String.format(
                        "送信された利用者は未登録のユーザです。利用者名：%s、パスワード：%s",
                        利用者認証情報.利用者名, 利用者認証情報.利用者パスワード
                    )
                )
            }

            return if (認証キーのチェックを行う(認証キー))
                User(利用者認証情報.利用者名, 利用者認証情報.利用者パスワード, AuthorityUtils.createAuthorityList("有効な会員"))
            else
                throw UsernameNotFoundException(String.format("認証キーが無効です。認証キー：%s", 認証キー))
        } catch (認証エラー: UsernameNotFoundException) {
            throw 認証エラー
        } catch (その他の例外: Throwable) {
            throw UsernameNotFoundException("システムエラーが発生しました。", その他の例外)
        }
    }

    private fun 認証キーのチェックを行う(認証キー: String): Boolean {
        // 後日、実装
        return true
    }
}

/**
 * 「prePostEnabled = true」で@PreAuthorizeアノテーションを有効化している
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
class 安全保障構成クラス : WebSecurityConfigurerAdapter() {

    /**
     *
     */
    @Bean
    fun 認証対象利用者詳細サービスを返す(): AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {
        return 認証対象利用者詳細サービスクラス()
    }

    /**
     *
     */
    @Bean
    fun 事前承認処理を提供する(): PreAuthenticatedAuthenticationProvider {
        val 事前承認処理提供者 = PreAuthenticatedAuthenticationProvider()
        事前承認処理提供者.setPreAuthenticatedUserDetailsService(認証対象利用者詳細サービスを返す())
        事前承認処理提供者.setUserDetailsChecker(AccountStatusUserDetailsChecker())
        return 事前承認処理提供者
    }

    /**
     *
     */
    @Bean
    @Throws(java.lang.Exception::class)
    fun 事前承認用濾過器を提供する(): AbstractPreAuthenticatedProcessingFilter {
        val 事前承認用濾過器 = 事前承認用濾過器クラス()
        事前承認用濾過器.setAuthenticationManager(authenticationManager())
        return 事前承認用濾過器
    }

    /**
     *
     */
    @Bean
    fun 未承認処理の設定情報を提供する(): AuthenticationEntryPoint? {

        return AuthenticationEntryPoint { リクエスト: HttpServletRequest?, レスポンス: HttpServletResponse, 承認例外: AuthenticationException? ->

            // ステータスコードは401(Unauthorized 認証エラー）としておく。
            レスポンス.status = HttpServletResponse.SC_UNAUTHORIZED

            // Content typeは、"application/json; charset=UTF-8" としておく。
            // レスポンスはJSON化した戻り値オブジェクトであり、レスポンスに含まれるエラーメッセージが日本語を使用しているため、上記のようなコンテントタイプとした
            val encodingName = Charsets.UTF_8.name()

            // 念のため、エンコーディングにもUTF-8をセット
            レスポンス.characterEncoding = encodingName

            // 下記で、セット後のcontentTypeを確認すると、メディアタイプとエンコーディング名の間の半角空白が消えているので、Unicodeエスケープで半角空白を記述している。
            レスポンス.contentType = String.format("%s;\u0020charset=%s", MediaType.APPLICATION_JSON_VALUE, encodingName)

            // レスポンスボディはJSON化文字列とする
            val レスポンスボディ = 認証エラーレスポンスを作成する()

            // 念のため、コンテント長をセット
            レスポンス.setContentLength(レスポンスボディ.length)

            // レスポンス.outputStream.println()を使用すると、セットしたエンコーディングが効かないため、煩雑だが、下記のようなコードにした
            try {
                レスポンス.writer.use { 出力ストリーム ->
                    try {
                        出力ストリーム.println(レスポンスボディ)
                    } catch (入出力例外１: IOException) {
                        ログ.エラーログを出力する(this.javaClass, 入出力例外１, メッセージID一覧.CMN_E_0002, "認証エラーレスポンスを送信する際にエラーが発生しました。")
                    } finally {
                        出力ストリーム.close()
                    }
                }
            } catch (入出力例外２: IOException) {
                ログ.エラーログを出力する(this.javaClass, 入出力例外２, メッセージID一覧.CMN_E_0002, "認証エラーレスポンスを送信する中にエラーが発生しました。")
            }

            // 詳細な情報をログに出力しておく。（レスポンスには詳細なエラー情報は含めない）
            認証エラーログを出力する(リクエスト, 承認例外)
        }
    }

    /**
     *
     */
    private fun 認証エラーログを出力する(リクエスト: HttpServletRequest?, 承認例外: AuthenticationException?) {
        val 文字列 = StringBuilder(500)
        文字列.append("\nHTTPリクエスト情報 -> ")
        if (リクエスト == null) {
            文字列.append("<null>")
        } else {
            文字列.append("requestURI：").append(リクエスト.requestURI).append("、")
            文字列.append("remoteAddr：").append(リクエスト.remoteAddr).append("、")
            文字列.append("remoteHost：").append(リクエスト.remoteHost).append("、")
            文字列.append("remotePort：").append(リクエスト.remotePort).append("、")
            文字列.append("remoteUser：").append(リクエスト.remoteUser).append("、")
            文字列.append("pathInfo：").append(リクエスト.pathInfo).append("、")
            文字列.append("queryString：\"").append(リクエスト.queryString).append("\"、")
            文字列.append("contextPath：").append(リクエスト.contextPath).append("、")
            文字列.append("method：").append(リクエスト.method).append("、")
            文字列.append("contentType：").append(リクエスト.contentType).append("、")
            文字列.append("contentLengthLong：").append(リクエスト.contentLengthLong).append("、")
            文字列.append("authType：").append(リクエスト.authType).append("、")
            文字列.append("characterEncoding：").append(リクエスト.characterEncoding)
        }
        文字列.append("\n承認エラー情報 -> ")
        if (承認例外 == null) {
            文字列.append("<null>")
        } else {
            文字列.append("message：\"").append(承認例外.message).append("\"、")
            文字列.append("cause：\"").append(承認例外.cause).append("\"、")
            文字列.append("stackTrace：").append(道具箱.スタックトレースを文字列化する(承認例外))
        }
        ログ.エラーログを出力する(this.javaClass, メッセージID一覧.BAS_E_0030, 文字列.toString())
    }

    /**
     *
     */
    private fun 認証エラーレスポンスを作成する(): String {
        return システムエラー系戻り値クラス(JSONフィールド名言語一覧.英語, メッセージID一覧.BAS_E_0029).返却値を作成してJSON化する()
    }

    /**
     *
     */
    @Throws(java.lang.Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .addFilter(事前承認用濾過器を提供する())
            .exceptionHandling().authenticationEntryPoint(未承認処理の設定情報を提供する())
            .and()
            // セッションを使用しない
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            // CSRF対策トークンを使用しない
            .csrf().disable()
            .cors()
    }
}

