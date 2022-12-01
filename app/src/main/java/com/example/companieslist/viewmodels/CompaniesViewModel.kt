package com.example.companieslist.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.companieslist.db.CompaniesRepository
import com.example.companieslist.model.CompaniesList
import com.example.companieslist.model.CompaniesListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CompaniesViewModel @Inject constructor(
    private val repository: CompaniesRepository
) : ViewModel() {

    var listCompanies: List<CompaniesListItem> by mutableStateOf(listOf())

    init {
        getList()
    }

    private fun getList() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getList(object : Callback<CompaniesList> {
                override fun onResponse(
                    call: Call<CompaniesList>,
                    response: Response<CompaniesList>
                ) {
                    response.body()?.let { responseBody ->
                        val list = mutableListOf<CompaniesListItem>()
                        responseBody.forEach {
                            list.add(it)
                        }
                        listCompanies = list
                    }
                }

                override fun onFailure(call: Call<CompaniesList>, t: Throwable) {
                }
            })
        }
    }
}