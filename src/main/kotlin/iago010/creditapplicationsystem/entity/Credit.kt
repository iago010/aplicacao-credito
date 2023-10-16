package iago010.creditapplicationsystem.entity

import iago010.creditapplicationsystem.enummeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*
import java.time.LocalDate

@Entity
@Table(name = "Credit")
data class Credit (
    @Column(nullable = false, unique = true) var creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstallment: LocalDate = LocalDate.now(), // ou outro valor padrão desejado
    @Column(nullable = false) val numberOfInstallments: Int = 0,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    @ManyToOne var customer: Customer? = null,
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY) val id: Long? = null
        )
