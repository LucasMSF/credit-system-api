package br.lucasdev.creditsystemapi.dto

import br.lucasdev.creditsystemapi.model.Address
import br.lucasdev.creditsystemapi.model.Customer

data class CustomerDto(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String,
): IDto<Customer> {
    override fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        email = this.email,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )

    fun toEntity(id: Long): Customer = Customer(
        id = id,
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        email = this.email,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}