package com.example.chattingapplication.Events

// i believe it is checking for it the error has been handled once if already then return null if no then return content my guess but i still dont see the reason fr creat ing this ?
// ! The primary purpose of event classes in Jetpack Compose, when used with ViewModels, is to prevent Composable functions from directly modifying the data or state held within the ViewModel.
open class Event<out T>(val content: T) {

    var isHandled = false;

    fun getContentOrReturnNull(): T?{
       return if(isHandled) null
        else{
            isHandled = true;
            return content;

        }
    }

}