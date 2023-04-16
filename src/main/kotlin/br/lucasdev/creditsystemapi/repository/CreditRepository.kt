package br.lucasdev.creditsystemapi.repository

import br.lucasdev.creditsystemapi.model.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditRepository : JpaRepository<Credit, Long>{
}
