package com.example.companieslist.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.companieslist.viewmodels.CompaniesViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CompaniesScreen(
    navController: NavController,
    viewModel: CompaniesViewModel = hiltViewModel()
) {

    val list = viewModel.listCompanies

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        items(list) { it ->
            Card(
                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                elevation = 4.dp,
                shape = MaterialTheme.shapes.small,
                onClick = {
                    navController.navigate("Details/${it.id}") {
                        popUpTo("CompaniesList")
                    }
                }) {
                Text(
                    text = it.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
                )
            }
        }
    }
}