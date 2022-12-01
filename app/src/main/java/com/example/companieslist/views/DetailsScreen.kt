package com.example.companieslist.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.companieslist.viewmodels.DetailsViewModel

@Composable
fun DetailsScreen(
    navController: NavController,
    id: String?,
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val item = viewModel.details

    if (item.value != null) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 5.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = item.value!!.name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 5.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = item.value!!.phone,
                        fontSize = 20.sp,
                    )
                    Text(
                        text = item.value!!.www,
                        fontSize = 20.sp,
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 5.dp)
                ) {
                    Text(
                        text = item.value!!.description
                    )
                }
            }
        }
    }
}