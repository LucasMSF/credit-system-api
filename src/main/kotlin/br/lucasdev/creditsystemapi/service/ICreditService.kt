package br.lucasdev.creditsystemapi.service

import br.lucasdev.creditsystemapi.model.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit:Credit): Credit

    fun findAllByCustomerId(customerId: Long): List<Credit>

    fun findByCreditCode(creditCode: UUID, customerId: Long): Credit
}