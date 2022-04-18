package name.uroak.uroak_service_center

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.ibatis.io.VFS
import org.apache.ibatis.session.AutoMappingBehavior
import org.apache.ibatis.session.Configuration
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.annotation.MapperScan
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.MultipartConfigFactory
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.PropertySource
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter
import org.springframework.util.unit.DataSize
import java.util.*
import javax.servlet.MultipartConfigElement
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.sql.DataSource


/**
 *
 */
@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = ["name.uroak.uroak_service_center"])
@PropertySource("classpath:messages.properties")
@MapperScan("name.uroak.uroak_service_center")
class Uroakサービスセンターアプリケーション : SpringBootServletInitializer() {

    /**
     *
     */
    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(Uroakサービスセンターアプリケーション::class.java)
    }

    /**
     *
     */
    @Bean
    @Autowired
    fun sqlSessionFactory(dataSource: DataSource): SqlSessionFactory? {

        VFS.addImplClass(SpringBootVFS::class.java)

        val config = Configuration()

        config.isMapUnderscoreToCamelCase = true

        config.autoMappingBehavior = AutoMappingBehavior.FULL

        config.isCallSettersOnNulls = true

        config.vfsImpl = SpringBootVFS::class.java

        val sqlSessionFactoryBean = SqlSessionFactoryBean()

        sqlSessionFactoryBean.setDataSource(dataSource)

        sqlSessionFactoryBean.vfs = SpringBootVFS::class.java

        //MyBatisタイプハンドラ用クラスを配置しているパッケージを登録する
        sqlSessionFactoryBean.setTypeHandlersPackage("name.uroak.uroak_service_center.shared.util.db.typehandlers")

        sqlSessionFactoryBean.setConfiguration(config)

        return sqlSessionFactoryBean.`object`
    }

    /**
     *
     */
    @Bean
    fun multipartConfigElement(): MultipartConfigElement {
        val factory = MultipartConfigFactory()
        val maxFileSize = DataSize.ofMegabytes(50)
        val maxRequestSize = DataSize.ofMegabytes(50)
        factory.setMaxFileSize(maxFileSize)
        factory.setMaxRequestSize(maxRequestSize)
        return factory.createMultipartConfig()
    }

    /**
     *
     */
    @Bean(name = ["messageSource"])
    fun messageSource(): MessageSource {
        val bean = ReloadableResourceBundleMessageSource()
        bean.setBasename("classpath:validation_messages")
        bean.setDefaultEncoding("UTF-8")
        return bean
    }

    /**
     *
     */
    @Bean
    @Autowired
    fun dataSource(dataSourceProperties: DataSourceProperties): DataSource {
        val dataSource = DriverManagerDataSource(
            dataSourceProperties.url,
            dataSourceProperties.username,
            dataSourceProperties.password
        )
        dataSource.setDriverClassName(dataSourceProperties.driverClassName)
        return TransactionAwareDataSourceProxy(dataSource)
    }

}

/**
 *
 */
fun main(args: Array<String>) {
    runApplication<Uroakサービスセンターアプリケーション>(*args)
}
