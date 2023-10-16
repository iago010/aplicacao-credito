package iago010.creditapplicationsystem.service

import iago010.creditapplicationsystem.entity.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)
}