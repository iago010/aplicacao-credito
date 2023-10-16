package iago010.creditapplicationsystem.dto

import iago010.creditapplicationsystem.entity.Credit
import iago010.creditapplicationsystem.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto (
    @field:NotNull(message = "Entrada inválida") val creditValue: BigDecimal,
    @field:Future val dayFirstOfInstallment: LocalDate,
    @field:Min(value = 1, message = "O número de parcelas deve ser pelo menos 1") val numberOfInstallments: Int,
    @field:NotNull(message = "Entrada inválida") val customerId: Long
){
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}