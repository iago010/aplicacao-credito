package iago010.creditapplicationsystem.dto

import iago010.creditapplicationsystem.entity.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "Entrada inválida") val firstName: String,
    @field:NotEmpty(message = "Entrada inválida") val lastName: String,
    @field:NotNull(message = "Entrada inválida") val income: BigDecimal,
    @field:NotEmpty(message = "Entrada inválida") val zipCode: String,
    @field:NotEmpty(message = "Entrada inválida") val street: String
){
    fun toEntity(customer: Customer) : Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode
        return customer
    }
}
