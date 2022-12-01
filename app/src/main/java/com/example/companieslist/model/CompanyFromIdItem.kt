package com.example.companieslist.model

data class CompanyFromIdItem(
    val id: String,
    val name: String,
    val img: String,
    val description: String,
    val lat: Double,
    val lon: Double,
    val www: String,
    val phone: String
)