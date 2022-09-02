package com.example.shopapp.data.local.entities


import androidx.room.Entity

@Entity
data class User(
    val id: Int,
    val email: String,
    val username: String,
    val password: String,
    val firstname: String,
    val lastname: String,
    val city: String,
    val street: String,
    val number: Int,
    val zipcode: String,
    val lat: String,
    val long: String,
    val phone: String
)