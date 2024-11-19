package com.example.chattingapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chattingapplication.Screens.AllChatScreenComposable
import com.example.chattingapplication.Screens.LoginScreenComposable
import com.example.chattingapplication.Screens.SignUpScreenComposable
import com.example.chattingapplication.Screens.StatusScreenComposable
import com.example.chattingapplication.Screens.UserProfileScreenComposable
import com.example.chattingapplication.ViewModels.ApplicationViewModel
import com.example.chattingapplication.ui.theme.ChattingApplicationTheme
import dagger.hilt.android.AndroidEntryPoint



//TODO:fg  understand the various further things about htis class i dont understand it completely?
sealed class ScreenRoutes(var route: String) {
    object SignInRoute : ScreenRoutes("signup");
    object LoginRoute : ScreenRoutes("login");
    object ChatListRoute : ScreenRoutes("ChatListRoute");
//Placeholder Replacement: Inside the createRoute function, the {chatId} placeholder in the base route is replaced with the actual value of the chatId argument ("123" in this case).
//Generated Route: The function then returns the complete route string, which would be "singlechat/123" in this example. Navigatio
    object SingleChatRoute : ScreenRoutes("SingleChatRoute/{chatId}") {
        fun createRoute(id: String) = "singlechat/$id";
    };
    object ProfileRoute : ScreenRoutes("ProfileRoute");

    object StatusListRoute : ScreenRoutes("ChatListRoute");
    object SingleStatusRoute : ScreenRoutes("SingleStatusRoute/{chatId}") {
        fun createRoute(id: String) = "singleStatus/$id";
    }
}

@AndroidEntryPoint
class MainActivity : ComponentActivity()  {
//    TODO: Fix the runtime exception
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        ChattingApplicationTheme {
            applicationNavigation();
        }
        }
    }
}


@Composable
fun applicationNavigation()  {
    val navController =  rememberNavController();
    var viewModel = hiltViewModel<ApplicationViewModel>()
    NavHost(navController = navController, startDestination = ScreenRoutes.SignInRoute.route) {


// TODO: look into composable functions in kotlin
        composable(route = ScreenRoutes.SignInRoute.route){
            SignUpScreenComposable(navController,viewModel);
        }
        composable(route = ScreenRoutes.ChatListRoute.route){
            AllChatScreenComposable(navController,viewModel)
        }
        composable(route = ScreenRoutes.LoginRoute.route){
            LoginScreenComposable(navController,viewModel);
        }
        composable(route = ScreenRoutes.ProfileRoute.route){
            UserProfileScreenComposable(navController,viewModel);
        }
        composable(route = ScreenRoutes.StatusListRoute.route){
            StatusScreenComposable(viewModel,navController);
        }



    }

}

