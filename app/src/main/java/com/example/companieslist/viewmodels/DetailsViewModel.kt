package com.example.companieslist.viewmodels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.example.companieslist.db.CompaniesRepository
import com.example.companieslist.model.CompanyFromId
import com.example.companieslist.model.CompanyFromIdItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: CompaniesRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _details = MutableLiveData<CompanyFromIdItem>()
    val details: LiveData<CompanyFromIdItem>
        get() = _details

    init {
        val id: String = checkNotNull(savedStateHandle["id"])
        getDetails(id)
    }

    private fun getDetails(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getDetails(id, object : Callback<CompanyFromId> {
                override fun onResponse(
                    call: Call<CompanyFromId>,
                    response: Response<CompanyFromId>
                ) {
                    response.body()?.let { responseBody ->
                        responseBody.forEach {
                            Log.d(TAG, it.toString())
                            _details.postValue(
                                CompanyFromIdItem(
                                    it.id,
                                    it.name,
                                    it.img,
                                    it.description,
                                    it.lat,
                                    it.lon,
                                    it.www,
                                    it.phone
                                )
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<CompanyFromId>, t: Throwable) {
                }
            })
        }
    }
}