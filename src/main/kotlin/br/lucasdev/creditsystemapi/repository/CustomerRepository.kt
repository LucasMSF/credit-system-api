package br.lucasdev.creditsystemapi.repository

import br.lucasdev.creditsystemapi.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long> {
}