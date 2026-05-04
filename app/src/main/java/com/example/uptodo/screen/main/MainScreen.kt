package com.example.uptodo.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.uptodo.navigation.BottomNavItem
import com.example.uptodo.ui.theme.DarkGray
import com.example.uptodo.R
import com.example.uptodo.ui.theme.PrimaryButton

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Calendar,
        BottomNavItem.Add,
        BottomNavItem.Focus,
        BottomNavItem.Profile
    )
    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = PrimaryButton,
                shape = CircleShape,
                modifier = Modifier.size(64.dp).offset(y = 50.dp),
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add", modifier = Modifier.size(32.dp))
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = DarkGray
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { item ->
                    val isSelected = item.route == currentRoute
                    val tintColor = if (isSelected) Color.White.copy(alpha = 0.87f) else Color.Black
                    val homeIconRes = if (isSelected && item == BottomNavItem.Home) R.drawable.home_icon_active else R.drawable.home_icon_inactive
                    val calendarIconRes = if (isSelected && item == BottomNavItem.Calendar) R.drawable.calendar_active else R.drawable.calendar_inactive
                    val focusIconRes = if (isSelected && item == BottomNavItem.Focus) R.drawable.clock_active else R.drawable.clock_inactive

                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent,
                        ),
                      selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route)
                        },
                        icon = {
                            when(item) {
                                BottomNavItem.Home -> {
                                   Icon(
                                       painter = painterResource(id = homeIconRes),
                                       contentDescription = "Home",
                                       tint = tintColor
                                   )
                                }
                                BottomNavItem.Calendar -> {
                                    Icon(
                                        painter = painterResource(id = calendarIconRes),
                                        contentDescription = "Calendar",
                                        tint = tintColor
                                    )
                                }
                                BottomNavItem.Add -> {}
                                BottomNavItem.Focus -> {
                                    Icon(
                                        painter = painterResource(id = focusIconRes),
                                        contentDescription = "Focus",
                                        tint = tintColor
                                    )
                                }
                                BottomNavItem.Profile -> Icon(Icons.Default.Person, contentDescription = "Profile", tint = tintColor)
                            }
                        },
                        label = {
                            if (item.route != BottomNavItem.Add.route) {
                                Text(
                                    text = item.title,
                                    color = tintColor
                                )
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(BottomNavItem.Home.route){
                HomeScreen()
            }
            composable(BottomNavItem.Calendar.route){
               CalendarScreen()
            }
            composable(BottomNavItem.Focus.route) {
                FocusScreen()
            }
            composable(BottomNavItem.Profile.route){
                ProfileScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    MainScreen()
}