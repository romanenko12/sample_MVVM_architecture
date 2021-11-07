package com.example.sample_mvvm_architecture.viewmodels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import android.text.TextUtils
import android.util.Patterns
import com.example.sample_mvvm_architecture.BR
import com.example.sample_mvvm_architecture.models.User

class LoginViewModel : BaseObservable() {
    private val user: User = User("", "")
    private val successMessage = "Login was successful"
    private val errorMessage = "Email or Password not valid"

    @Bindable
    var toastMessage: String? = null
        private set

    private fun setToastMessage(toastMessage: String) {
        this.toastMessage = toastMessage
        notifyPropertyChanged(BR.toastMessage)
    }

    @get:Bindable
    var userEmail: String?
        get() = user.email
        set(email) {
            user.email = email!!
            notifyPropertyChanged(BR.userEmail)
        }

    @get:Bindable
    var userPassword: String?
        get() = user.password
        set(password) {
            user.password = password!!
            notifyPropertyChanged(BR.userPassword)
        }

    fun onLoginClicked() {
        if (isInputDataValid) setToastMessage(successMessage) else setToastMessage(errorMessage)
    }

    private val isInputDataValid: Boolean
        get() = !TextUtils.isEmpty(userEmail) && Patterns.EMAIL_ADDRESS.matcher(userEmail).matches() && userPassword!!.length > 5
}
