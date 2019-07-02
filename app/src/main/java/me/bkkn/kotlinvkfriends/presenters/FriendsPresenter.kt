package me.bkkn.kotlinvkfriends.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import me.bkkn.kotlinvkfriends.R
import me.bkkn.kotlinvkfriends.models.FriendModel
import me.bkkn.kotlinvkfriends.providers.FriendsProvider
import me.bkkn.kotlinvkfriends.views.FriendsView
import javax.inject.Inject

@InjectViewState
class FriendsPresenter: MvpPresenter<FriendsView>() {
    fun loadFriends() {
        viewState.startLoading()
        FriendsProvider(presenter = this).testLoadFriends(hasFriends = false)
    }

    fun friendsLoaded(friendsList: ArrayList<FriendModel>){
        viewState.endLoading()
        if(friendsList.size == 0){
            viewState.setupEmptyList()
            viewState.showError(textResource = R.string.no_friends)
        }else{
            viewState.setupFriendsList(friendsList = friendsList)
        }
    }

}