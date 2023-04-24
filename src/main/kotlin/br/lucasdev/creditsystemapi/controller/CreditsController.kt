package br.lucasdev.creditsystemapi.controller

import br.lucasdev.creditsystemapi.dto.CreditDto
import br.lucasdev.creditsystemapi.service.impl.CreditService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/credits")
class CreditsController(
    private val creditService: CreditService
) {
    @GetMapping("/customer/{id}")
    fun creditsByCustomerId(@PathVariable("id") id: Long) = this.creditService.findAllByCustomerId(id)

    @GetMapping("/customer/{customerId}/{creditCode}")
    fun creditByCustomerIdAndCreditCode(
        @PathVariable("customerId") customerId: Long,
        @PathVariable("creditCode") creditCode: UUID
    ) = this.creditService.findByCreditCode(creditCode, customerId)

    @PostMapping
    fun save(@RequestBody creditDto: CreditDto): String {
        this.creditService.save(creditDto.toEntity())
        return "Credit created"
    }

}