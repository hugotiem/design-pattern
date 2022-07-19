package fr.hugotiem.designpattern.model

import androidx.lifecycle.MutableLiveData

class User(val email: String, val name: String)

object CurrentUser {
    val userLiveData = MutableLiveData<User?>()

    var currentUser: User?
        get() = userLiveData.value
        set(value) {
            userLiveData.postValue(value)
        }
}