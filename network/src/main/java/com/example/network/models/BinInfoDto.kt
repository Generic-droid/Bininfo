package com.example.network.models

data class BinInfoDto(
    val id: Int = 0,
    val number: NumberDto,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: String?,
    val country: CountryDto,
    val bank: BankDto,
)

data class NumberDto(
    val length: String?,
    val luhn: String?
)

data class CountryDto(
    val numeric: String?,
    val alpha2: String?,
    val name: String?,
    val emoji: String?,
    val currency: String?,
    val latitude: String?,
    val longitude: String?
)

data class BankDto(
    val name: String?,
    val url: String?,
    val phone: String?,
    val city: String?
)
