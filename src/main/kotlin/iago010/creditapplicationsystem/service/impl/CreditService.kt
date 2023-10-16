package iago010.creditapplicationsystem.service.impl

import iago010.creditapplicationsystem.entity.Credit
import iago010.creditapplicationsystem.exception.BusinessException
import iago010.creditapplicationsystem.repository.CreditRepository
import iago010.creditapplicationsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.UUID

@Service
class CreditService (
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomerId(customerId)



    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw BusinessException("Creditcode $creditCode não encontrado") )
        return if (credit.customer?.id == customerId) credit else throw IllegalArgumentException("Contate o administrador.")
    }
}