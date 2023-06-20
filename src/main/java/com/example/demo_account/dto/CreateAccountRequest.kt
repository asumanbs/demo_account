package com.example.demo_account.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import java.math.BigDecimal

data class CreateAccountRequest(
    @field:NotBlank(message = "customer not blank")
    val customerId: String,
    @field:Min(0)
    val initialCredit: BigDecimal
)
