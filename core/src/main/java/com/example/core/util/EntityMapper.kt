package com.example.core.util

interface EntityMapper<Entity, Model> {

    fun mapFromEntity(entity: Entity): Model

    fun mapToEntity(model: Model): Entity
}