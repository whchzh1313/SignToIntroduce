package com.example.signtointroduce

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String,
    val id: String,
    val pw: String,
    val mbti: String
) : Parcelable
