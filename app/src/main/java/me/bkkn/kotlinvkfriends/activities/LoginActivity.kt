package me.bkkn.kotlinvkfriends.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.github.rahatarmanahmed.cpv.CircularProgressView
import me.bkkn.kotlinvkfriends.R
import me.bkkn.kotlinvkfriends.presenters.LoginPresenter
import me.bkkn.kotlinvkfriends.views.LoginView

class LoginActivity : MvpAppCompatActivity(), LoginView {

    private lateinit var mCpvWait: CircularProgressView
    private lateinit var mBtnEnter: Button
    private lateinit var mTxtLoginHello: TextView


    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTxtLoginHello = findViewById(R.id.text_login_hello)
        mBtnEnter = findViewById(R.id.button)
        mCpvWait = findViewById(R.id.cpv_login)

        mBtnEnter.setOnClickListener { loginPresenter.login(isSuccess = true) }
    }
    override fun startLoading() {
        mBtnEnter.visibility = View.GONE
        mCpvWait.visibility = View.VISIBLE
    }

    override fun endLoading() {
        mBtnEnter.visibility = View.VISIBLE
        mCpvWait.visibility = View.GONE
    }

    override fun showError(textResource: Int) {
        Toast.makeText(applicationContext,getString(textResource),Toast.LENGTH_SHORT).show()
    }

    override fun openFriends() {
        startActivity(Intent(applicationContext, FriendsActivity::class.java))
    }

}
