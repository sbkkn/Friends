package me.bkkn.kotlinvkfriends.presenters

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import me.bkkn.kotlinvkfriends.R
import me.bkkn.kotlinvkfriends.views.LoginView

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {
    fun login(isSuccess: Boolean) {
        viewState.startLoading()
        Handler().postDelayed({
            viewState.endLoading()
            if (isSuccess) {
                viewState.openFriends()
            } else {
                viewState.showError(textResource = R.string.login_error)
            }
        }, 500)
    }
}