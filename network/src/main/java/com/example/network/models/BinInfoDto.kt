package com.example.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BinInfoDto(
    @Json(name = "number")
    val number: NumberDto,
    @Json(name = "scheme")
    val scheme: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "brand")
    val brand: String?,
    @Json(name = "prepaid")
    val prepaid: Boolean?,
    @Json(name = "country")
    val country: CountryDto,
    @Json(name = "bank")
    val bank: BankDto
) {

    @JsonClass(generateAdapter = true)
    data class NumberDto(
        @Json(name = "length")
        val length: String?,
        @Json(name = "luhn")
        val luhn: Boolean?
    )

    @JsonClass(generateAdapter = true)
    data class CountryDto(
        @Json(name = "numeric")
        val numeric: String?,
        @Json(name = "alpha2")
        val alpha2: String?,
        @Json(name = "name")
        val name: String?,
        @Json(name = "emoji")
        val emoji: String?,
        @Json(name = "currency")
        val currency: String?,
        @Json(name = "latitude")
        val latitude: String?,
        @Json(name = "longitude")
        val longitude: String?
    )

    @JsonClass(generateAdapter = true)
    data class BankDto(
        @Json(name = "name")
        val name: String?,
        @Json(name = "url")
        val url: String?,
        @Json(name = "phone")
        val phone: String?,
        @Json(name = "city")
        val city: String?
    )
}
