package me.bkkn.kotlinvkfriends.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.github.rahatarmanahmed.cpv.CircularProgressView
import me.bkkn.kotlinvkfriends.R
import me.bkkn.kotlinvkfriends.models.FriendModel
import me.bkkn.kotlinvkfriends.presenters.FriendsPresenter
import me.bkkn.kotlinvkfriends.views.FriendsView

class FriendsActivity : AppCompatActivity(), FriendsView {

    private lateinit var mCpvWait: CircularProgressView
    private lateinit var mTxtNoItems: TextView
    private lateinit var mRvFriends: RecyclerView

    @InjectPresenter
    lateinit var friendsPresenter: FriendsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        mRvFriends = findViewById(R.id.recycler_friends)
        mTxtNoItems = findViewById(R.id.txt_friends_no_items)
        mCpvWait = findViewById(R.id.cpv_friends)

        friendsPresenter.loadFriends()
    }

    override fun showError(textResource: Int) {
        mTxtNoItems.text = getString(textResource)
    }

    override fun setupEmptyList() {
        mRvFriends.visibility = View.GONE
        mTxtNoItems.visibility = View.VISIBLE
    }

    override fun setupFriendsList(friendsList: ArrayList<FriendModel>) {
        mRvFriends.visibility = View.VISIBLE
        mTxtNoItems.visibility = View.GONE
    }

    override fun startLoading() {
        mRvFriends.visibility = View.VISIBLE
        mTxtNoItems.visibility = View.GONE
        mCpvWait.visibility = View.GONE

    }

    override fun endLoading() {
        mCpvWait.visibility = View.GONE
    }

}
