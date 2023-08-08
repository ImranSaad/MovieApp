package com.example.movieapp.navigation

enum class MovieScreens{
    HomeScreen,
    DetailsScreeen;
    companion object{
        fun fromRoute(route: String?): MovieScreens
        = when (route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            DetailsScreeen.name -> DetailsScreeen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognize")
        }
    }
}