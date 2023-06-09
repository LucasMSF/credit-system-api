package br.lucasdev.creditsystemapi.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
data class Credit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false, unique = true)
    val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false)
    val numberOfInstallments: Int = 0,
    @Column(nullable = false)
    val dayFirstInstallment: LocalDate,
    @Enumerated
    val status: Status = Status.IN_PROGRESS,
    @ManyToOne
    var customer: Customer? = null
)
