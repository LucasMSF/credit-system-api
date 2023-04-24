package br.lucasdev.creditsystemapi.dto

import br.lucasdev.creditsystemapi.model.Credit
import br.lucasdev.creditsystemapi.model.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val numberOfInstallments: Int,
    val dayFirstInstallment: LocalDate,
    val customerId: Long
): IDto<Credit> {
    override fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        numberOfInstallments = this.numberOfInstallments,
        dayFirstInstallment = this.dayFirstInstallment,
        customer = Customer(id = this.customerId)
    )
}
