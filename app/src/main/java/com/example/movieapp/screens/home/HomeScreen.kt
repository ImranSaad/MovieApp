package com.example.movieapp.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.Movierow
import com.example.movieapp.model.getMovies
import com.example.movieapp.navigation.MovieScreens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Magenta,
                elevation = 5.dp) {
                Text(text = "Movies")
            }
        }) {
        MainContent(navController = navController)
    }
}

val MovieList = getMovies()
@Composable
fun MainContent(navController: NavController){

    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = MovieList){
                Movierow(movie = it){ movie ->
                    navController.navigate(route = MovieScreens.DetailsScreeen.name+"/$movie")

                }
            }
        }

    }

}