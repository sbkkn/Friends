package me.bkkn.kotlinvkfriends.providers

import android.os.Handler
import me.bkkn.kotlinvkfriends.models.FriendModel
import me.bkkn.kotlinvkfriends.presenters.FriendsPresenter

class FriendsProvider(var presenter: FriendsPresenter) {
    fun testLoadFriends(hasFriends: Boolean) {
        Handler().postDelayed({
            var friendsList: ArrayList<FriendModel> = ArrayList()
            if (hasFriends) {
                val friend1 = FriendModel(
                    name = "Ivan",
                    surname = "Ivanov",
                    city = null,
                    avatar = "https://www.google.ru/imgres?imgurl=https%3A%2F%2Fvokrug.tv%2Fpic%2Fperson%2F6%2F4%2Ff%2F7%2F64f7e4c2f0721c3fdb50c291ecf47199.jpeg&imgrefurl=https%3A%2F%2Fwww.vokrug.tv%2Fperson%2Fshow%2Fivan_ivanov-vano%2F&docid=UHoubIauaKORGM&tbnid=0G_DQc4OWvmG2M%3A&vet=10ahUKEwjqwNae2ZbjAhULEpoKHaVkDx8QMwhOKAcwBw..i&w=240&h=320&hl=ru&bih=815&biw=1638&q=%D0%B8%D0%B2%D0%B0%D0%BD%20%D0%B8%D0%B2%D0%B0%D0%BD%D0%BE%D0%B2&ved=0ahUKEwjqwNae2ZbjAhULEpoKHaVkDx8QMwhOKAcwBw&iact=mrc&uact=8",
                    isOnline = true
                )
                val friend2 = FriendModel(
                    name = "Egor",
                    surname = "Sidorov",
                    city = null,
                    avatar = "https://www.google.ru/imgres?imgurl=https%3A%2F%2Fi.mycdn.me%2Fimage%3Fid%3D882154242387%26ts%3D000000013400610190%26plc%3DWEB%26tkn%3D*0VsCvG4qvcU5Ieso7XAKbgbTMqU%26fn%3Dsqr_288&imgrefurl=https%3A%2F%2Fok.ru%2Fprofile%2F550968248659&docid=8LKfdGixPY07-M&tbnid=PeXqwjWBAbniHM%3A&vet=10ahUKEwj53_nM2ZbjAhWXysQBHRQ-B2kQMwh5KC0wLQ..i&w=288&h=288&itg=1&hl=ru&bih=815&biw=1638&q=tujh%20cbljhjd&ved=0ahUKEwj53_nM2ZbjAhWXysQBHRQ-B2kQMwh5KC0wLQ&iact=mrc&uact=8",
                    isOnline = true
                )
                val friend3 = FriendModel(
                    name = "Петя",
                    surname = "Петров",
                    city = null,
                    avatar = "https://www.google.ru/imgres?imgurl=https%3A%2F%2Fwww.s-vfu.ru%2Fupload%2Fiblock%2Fca4%2Fca45e3ffc16eec7d5da08283e4ac502a.jpg&imgrefurl=https%3A%2F%2Fwww.s-vfu.ru%2Funiversitet%2Frukovodstvo-i-struktura%2Finstituty%2Fflf%2Fvet%2Fdetail.php%3FSECTION_ID%3D2573%26ID%3D37706&docid=a0cXH3A9ve6wiM&tbnid=nWFWBuU64DXPaM%3A&vet=10ahUKEwj53_nM2ZbjAhWXysQBHRQ-B2kQMwhlKBkwGQ..i&w=150&h=187&hl=ru&bih=815&biw=1638&q=tujh%20cbljhjd&ved=0ahUKEwj53_nM2ZbjAhWXysQBHRQ-B2kQMwhlKBkwGQ&iact=mrc&uact=8",
                    isOnline = true
                )
                friendsList.add(friend1)
                friendsList.add(friend2)
                friendsList.add(friend3)
            }
            presenter.friendsLoaded(friendsList = friendsList)
        }, 2000)
    }
}