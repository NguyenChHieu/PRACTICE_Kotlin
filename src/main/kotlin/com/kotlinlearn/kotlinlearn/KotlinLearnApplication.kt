package com.kotlinlearn.kotlinlearn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinLearnApplication

fun main(args: Array<String>) {
	runApplication<KotlinLearnApplication>(*args)
}
