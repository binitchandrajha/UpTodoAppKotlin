package com.example.uptodo.navigation

sealed class BottomNavItem(val route: String, val title: String){
    object Home : BottomNavItem("home", "Home")
    object Calendar : BottomNavItem("calendar", "Calendar")

    object Add: BottomNavItem(route = "add", title = "Add")
    object Focus : BottomNavItem("focus", "Focus")
    object Profile: BottomNavItem(route = "profile", title = "Profile")
}