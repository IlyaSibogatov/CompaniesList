package com.example.companieslist.db

import com.example.companieslist.model.ApiService
import com.example.companieslist.model.CompaniesList
import com.example.companieslist.model.CompanyFromId
import retrofit2.Callback
import javax.inject.Inject

class CompaniesRepository @Inject constructor(private val api: ApiService) {
    fun getList(callback: Callback<CompaniesList>) {
        api.getList().enqueue(callback)
    }

    fun getDetails(id: String, callback: Callback<CompanyFromId>) {
        api.getFromId(id).enqueue(callback)
    }
}