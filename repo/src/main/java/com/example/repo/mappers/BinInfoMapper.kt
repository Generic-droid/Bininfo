package com.example.repo.mappers

import com.example.core.util.EntityMapper
import com.example.database.entities.BinInfoEntity
import com.example.network.models.BinInfoDto

class BinInfoMapper : EntityMapper<BinInfoEntity, BinInfoDto> {
    override fun mapFromEntity(entity: BinInfoEntity): BinInfoDto {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(model: BinInfoDto): BinInfoEntity {
        return BinInfoEntity(
            numberLength = model.number.length ?: "",
            numberLuhn = model.number.luhn ?: "",
            scheme = model.scheme ?: "",
            type = model.type ?: "",
            brand = model.type ?: "",
            prepaid = model.prepaid ?: "",
            countryNumeric = model.country.numeric ?: "",
            countryAlpha2 = model.country.alpha2 ?: "",
            countryName = model.country.name ?: "",
            countryEmoji = model.country.emoji ?: "",
            countryCurrency = model.country.currency ?: "",
            countryLatitude = model.country.latitude ?: "",
            countryLongitude = model.country.longitude ?: "",
            bankName = model.bank.name ?: "",
            bankUrl = model.bank.url ?: "",
            bankPhone = model.bank.phone ?: "",
            bankCity = model.bank.city ?: ""
        )
    }
}