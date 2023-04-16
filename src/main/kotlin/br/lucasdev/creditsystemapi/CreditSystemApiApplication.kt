package br.lucasdev.creditsystemapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CreditSystemApiApplication

fun main(args: Array<String>) {
	runApplication<CreditSystemApiApplication>(*args)
}
