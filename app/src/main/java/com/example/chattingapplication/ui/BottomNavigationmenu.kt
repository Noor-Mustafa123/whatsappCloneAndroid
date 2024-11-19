package com.example.chattingapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chattingapplication.R
import com.example.chattingapplication.ScreenRoutes


// * Were creating an enum of the eachNavigation item because we want to loop through each one by one to check for the status that if the screen is open when the function BottomNavigationMenu is called

//? why do we use sealed classes when we have enums?
enum class BottomNavigationItem(val image: Int, val screenRoutes: ScreenRoutes) {
    ALLCHATLIST(R.drawable.GxIconPng, ScreenRoutes.ChatListRoute),
    STATUSLIST(R.drawable.sofa, ScreenRoutes.StatusListRoute),
    PROFILEPAGE(R.drawable.GxIconPng, ScreenRoutes.ProfileRoute)
}


@Composable
fun BottomNavigationMenu(navController: NavController, selectedScreen: BottomNavigationItem) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 4.dp)
            .background(color = Color.Gray)
    ) {
        for (item in BottomNavigationItem.values()) {
            Image(
                painter = painterResource(item.image),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(4.dp)
                    .weight(1f)
                    .clickable() {
                        navController.navigate(item.screenRoutes.route)

                    }, colorFilter = if (item == selectedScreen) {
                    ColorFilter.tint(Color.Black)
                } else {
                    ColorFilter.tint(Color.Gray)
                }
            )
        }
    }

}