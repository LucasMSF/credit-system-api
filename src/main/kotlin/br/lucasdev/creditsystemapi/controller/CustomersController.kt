package br.lucasdev.creditsystemapi.controller

import br.lucasdev.creditsystemapi.dto.CustomerDto
import br.lucasdev.creditsystemapi.model.Customer
import br.lucasdev.creditsystemapi.service.impl.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomersController(
    private val customerService: CustomerService
) {

    @GetMapping("/{id}")
    fun customers(@PathVariable("id") id: Long): Customer {
        return this.customerService.findById(id);
    }

    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String {
        this.customerService.save(customerDto.toEntity());
        return "Customer created"
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable("id") id: Long): String {
        this.customerService.delete(id);
        return "Customer #$id deleted"

    }

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable("id") id: Long, @RequestBody customerDto: CustomerDto): String {
        val customer: Customer = this.customerService.findById(id)
        this.customerService.save(customerDto.toEntity(customer.id!!));
        return "Customer #$id updated"

    }
}