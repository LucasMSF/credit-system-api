package br.lucasdev.creditsystemapi.model

import jakarta.persistence.*

@Entity
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false)
    var firstName: String? = null,
    @Column(nullable = false)
    var lastName: String? = null,
    @Column(nullable = false, unique = true)
    val cpf: String? = null,
    @Column(nullable = false, unique = true)
    var email: String? = null,
    @Column(nullable = false)
    @Embedded
    var address: Address = Address(),
    @Column(nullable = false, unique = true)
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.REMOVE],
        mappedBy = "customer"
        )
    var credits: List<Credit> = mutableListOf()
)
