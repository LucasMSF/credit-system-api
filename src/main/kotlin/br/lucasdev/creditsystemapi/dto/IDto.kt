package br.lucasdev.creditsystemapi.dto

interface IDto<T> {
    fun toEntity(): T
}