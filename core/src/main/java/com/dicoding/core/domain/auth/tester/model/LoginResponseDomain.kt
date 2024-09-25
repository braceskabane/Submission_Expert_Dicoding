package com.dicoding.core.domain.auth.tester.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginResponseDomain (
    val data: LoginDomain?,
    val error: Boolean,
    val message: String
) : Parcelable