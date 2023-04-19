package br.lucasdev.creditsystemapi.service

import br.lucasdev.creditsystemapi.model.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer

    fun findById(customerId: Long): Customer

    fun delete(customerId: Long): Unit
}