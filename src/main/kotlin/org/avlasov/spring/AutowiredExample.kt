package org.avlasov.spring

import org.avlasov.spring.config.AppConfig
import org.avlasov.spring.entity.Component
import org.junit.Assert.assertNotNull
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 *   Created By artemvlasov on 2018-10-24
 **/
fun main(args: Array<String>) {
    val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val bean = applicationContext.getBean(Component::class.java)
    assertNotNull(bean)
    assertNotNull(bean.baseComponent)
}