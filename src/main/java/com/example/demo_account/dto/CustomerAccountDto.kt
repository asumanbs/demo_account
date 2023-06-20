package com.example.demo_account.dto

import com.example.demo_account.model.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime

data class CustomerAccountDto(
    val id: String?,
    val balance: BigDecimal? = BigDecimal.ZERO,
    val transaction: Set<TransactionDto>?,
    val creationDate: LocalDateTime

)
