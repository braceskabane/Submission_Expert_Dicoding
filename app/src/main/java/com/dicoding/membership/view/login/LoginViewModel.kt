package com.dicoding.membership.view.login

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.core.domain.auth.tester.usecase.AuthUseCaseTester
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCaseTester: AuthUseCaseTester
) : ViewModel() {

//    private val _loginResult = MutableStateFlow<Resource<LoginResponseDomain>>(Resource.Loading())
//    val loginResult: StateFlow<Resource<LoginResponseDomain>> = _loginResult

    fun login(email: String, password: String) =
        authUseCaseTester.loginUser(email, password).asLiveData()

    private fun saveAccessToken(token: String) = authUseCaseTester.saveAccessToken(token).asLiveData()

    private fun getAccessToken() = authUseCaseTester.getAccessToken().asLiveData()

    fun saveLoginStatus(isLogin: Boolean) = authUseCaseTester.saveLoginStatus(isLogin).asLiveData()

    fun executeValidateToken(accessToken: String): MediatorLiveData<String> =
        MediatorLiveData<String>().apply {
            addSource(saveAccessToken(accessToken)) { accessTokenSaved ->
                if (accessTokenSaved) {
                    addSource(getAccessToken()) { token ->
                        value = token
                    }
                }
            }
        }
}
