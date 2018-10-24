package org.avlasov.spring.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 *   Created By artemvlasov on 2018-10-24
 **/
@Configuration
@ComponentScan(basePackages = ["org.avlasov.spring.entity"])
class AppConfig