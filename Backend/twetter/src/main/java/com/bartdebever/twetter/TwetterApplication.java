package com.bartdebever.twetter

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
object TwetterApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(TwetterApplication::class.java, args)
    }
}
