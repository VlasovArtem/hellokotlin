package org.avlasov.spring.entity

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 *   Created By artemvlasov on 2018-10-24
 **/
@Component
class Component(@Autowired val baseComponent: BaseComponent)