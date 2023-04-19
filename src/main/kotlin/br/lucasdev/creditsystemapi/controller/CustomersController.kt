package br.lucasdev.creditsystemapi.controller

import br.lucasdev.creditsystemapi.dto.CustomerDto
import br.lucasdev.creditsystemapi.model.Customer
import br.lucasdev.creditsystemapi.service.impl.CustomerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}