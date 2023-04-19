package br.lucasdev.creditsystemapi.service.impl

import br.lucasdev.creditsystemapi.model.Credit
import br.lucasdev.creditsystemapi.repository.CreditRepository
import br.lucasdev.creditsystemapi.service.ICreditService
import br.lucasdev.creditsystemapi.service.ICustomerService
import java.lang.Exception
import java.util.*

class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: ICustomerService
) : ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            this.customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomerId(customerId: Long): List<Credit> = this.creditRepository.findByCustomerId(customerId)

    override fun findByCreditCode(creditCode: UUID, customerId: Long): Credit {
        return this.creditRepository
            .findByCreditCodeAndCustomerId(creditCode, customerId)
            ?: throw Exception("Not found")
    }
}