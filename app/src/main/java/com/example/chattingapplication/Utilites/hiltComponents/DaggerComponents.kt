package com.example.chattingapplication.Utilites.hiltComponents

import com.example.chattingapplication.ViewModels.ApplicationViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.storage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DaggerComponents {
    @Provides
    fun provideFireBaseAuth(): FirebaseAuth = Firebase.auth

    @Provides
    fun provideFireStore() : FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideFirebaseImageStore() : FirebaseStorage = Firebase.storage



}