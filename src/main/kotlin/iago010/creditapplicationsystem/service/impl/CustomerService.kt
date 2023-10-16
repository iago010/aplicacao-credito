package iago010.creditapplicationsystem.service.impl

import iago010.creditapplicationsystem.entity.Customer
import iago010.creditapplicationsystem.exception.BusinessException
import iago010.creditapplicationsystem.repository.CustomerRepository
import iago010.creditapplicationsystem.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)

    override fun findById(id: Long): Customer = this.customerRepository.findById(id).orElseThrow {
        throw BusinessException("Id $id não encontrado")
    }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }

}