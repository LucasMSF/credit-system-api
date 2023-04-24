package br.lucasdev.creditsystemapi.service.impl

import br.lucasdev.creditsystemapi.model.Customer
import br.lucasdev.creditsystemapi.repository.CustomerRepository
import br.lucasdev.creditsystemapi.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)

    override fun findById(customerId: Long): Customer = this
        .customerRepository
        .findById(customerId).orElseThrow{
            throw Exception("Not Found")
        }
    override fun delete(customerId: Long): Unit {
        val customer: Customer = this.findById(customerId)
        this.customerRepository.deleteById(customer.id!!)
    }
}