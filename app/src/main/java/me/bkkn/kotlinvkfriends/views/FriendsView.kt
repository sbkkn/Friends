package me.bkkn.kotlinvkfriends.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import me.bkkn.kotlinvkfriends.models.FriendModel

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsView : MvpView {
    fun startLoading()
    fun endLoading()
    fun showError(textResource: Int)
    fun setupEmptyList()
    fun setupFriendsList(friendsList: ArrayList<FriendModel>)
}