package name.uroak.uroak_service_center.shared.util.core

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

/**
 *
 */
@Component
class DIコンポーネント検索クラス : ApplicationContextAware {

    /***/
    @Autowired
    private lateinit var コンテキスト: ApplicationContext

    /**
     *
     */
    constructor()

    /**
     *
     */
    fun <コンポーネント型> DIコンポーネントを取得する(ビーンクラス: Class<コンポーネント型>): コンポーネント型? {
        return コンテキスト.getBean(ビーンクラス)
    }

    /**
     *
     */
    fun <コンポーネント型> DIコンポーネントを取得する(ビーンクラス名: String): コンポーネント型? {
        return コンテキスト.getBean(ビーンクラス名) as コンポーネント型
    }

    /**
     *
     */
    override fun setApplicationContext(コンテキスト: ApplicationContext) {
        this.コンテキスト = コンテキスト
    }
}

