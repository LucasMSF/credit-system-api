package br.lucasdev.creditsystemapi.model

data class Customer(
    val id: Long? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    val cpf: String? = null,
    var email: String? = null,
    var address: Address = Address(),
    var credits: List<Credit> = mutableListOf()
)
