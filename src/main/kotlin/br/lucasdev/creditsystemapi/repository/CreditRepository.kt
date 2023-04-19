package br.lucasdev.creditsystemapi.repository

import br.lucasdev.creditsystemapi.model.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CreditRepository : JpaRepository<Credit, Long>{
    fun findByCreditCodeAndCustomerId(creditCode: UUID, customerId: Long): Credit?

    fun findByCustomerId(customerId: Long): List<Credit>
}
