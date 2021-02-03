package com.example.saretrofit2
data class UsersData(
    val contacts: List<Contact>
)

data class Contact(
    val address: String,
    val email: String,
    val gender: String,
    val id: String,
    val name: String,
    val phone: Phone
)

data class Phone(
    val home: String,
    val mobile: String,
    val office: String
)