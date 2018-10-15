package org.avlasov.spring.controller

import org.avlasov.spring.entity.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

/**
 *   Created By artemvlasov on 2018-10-10
 **/
@RestController
class GreetingController {

    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) = Greeting(counter.incrementAndGet(), "Hello, $name")

}