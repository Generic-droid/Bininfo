package com.example.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.models.BinInfo

@Entity(tableName = "bin_info_table")
data class BinInfoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    override val id: Int = 0,
    @ColumnInfo(name = "number_length")
    override val numberLength: String,
    @ColumnInfo(name = "number_luhn")
    override val numberLuhn: String,
    @ColumnInfo(name = "scheme")
    override val scheme: String,
    @ColumnInfo(name = "type")
    override val type: String,
    @ColumnInfo(name = "brand")
    override val brand: String,
    @ColumnInfo(name = "prepaid")
    override val prepaid: String,
    @ColumnInfo(name = "country_numeric")
    override val countryNumeric: String,
    @ColumnInfo(name = "country_alpha2")
    override val countryAlpha2: String,
    @ColumnInfo(name = "country_name")
    override val countryName: String,
    @ColumnInfo(name = "country_emoji")
    override val countryEmoji: String,
    @ColumnInfo(name = "country_currency")
    override val countryCurrency: String,
    @ColumnInfo(name = "country_latitude")
    override val countryLatitude: String,
    @ColumnInfo(name = "country_longitude")
    override val countryLongitude: String,
    @ColumnInfo(name = "bank_name")
    override val bankName: String,
    @ColumnInfo(name = "bank_url")
    override val bankUrl: String,
    @ColumnInfo(name = "bank_phone")
    override val bankPhone: String,
    @ColumnInfo(name = "bank_city")
    override val bankCity: String

) : BinInfo