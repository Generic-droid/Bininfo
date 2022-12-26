package com.example.core.models

interface BinInfo {
    val id: Int
    val numberLength: String
    val numberLuhn: String
    val scheme: String
    val type: String
    val brand: String
    val prepaid: String
    val countryNumeric: String
    val countryAlpha2: String
    val countryName: String
    val countryEmoji: String
    val countryCurrency: String
    val countryLatitude: String
    val countryLongitude: String
    val bankName: String
    val bankUrl: String
    val bankPhone: String
    val bankCity: String
}