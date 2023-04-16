package br.lucasdev.creditsystemapi.model

import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

data class Credit(
    val id: Long? = null,
    val creditCode: UUID = UUID.randomUUID(),
    val creditValue: BigDecimal = BigDecimal.ZERO,
    val numberOfInstallments: Int = 0,
    val dayFirstInstallment: LocalDate,
    val status: Status = Status.IN_PROGRESS,
    val customer: Customer? = null
)
