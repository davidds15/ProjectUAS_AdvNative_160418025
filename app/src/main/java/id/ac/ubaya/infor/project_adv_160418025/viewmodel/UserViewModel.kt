package id.ac.ubaya.infor.project_adv_160418025.viewmodel

import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.infor.project_adv_160418025.model.Cooking
import id.ac.ubaya.infor.project_adv_160418025.util.buildDB
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import id.ac.ubaya.infor.project_adv_160418025.model.User
import id.ac.ubaya.infor.project_adv_160418025.util.buildDB
import id.ac.ubaya.infor.project_adv_160418025.view.CookingDetailFragmentArgs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope  {
    private val job = Job()
    val userLD= MutableLiveData<User>()
    val userLoadErrorLD= MutableLiveData<Boolean>()
    val loadingLD= MutableLiveData<Boolean>()

    fun fetch (username:String,password:String)
    {
        launch{
            val db= buildDB(getApplication())
            userLD.value=db.cookingDao().selectUser(username,password)
            userLoadErrorLD.value=false
            loadingLD.value=false
        }
    }
    fun showProfile ()
    {
        launch{
            val username="user1"
            val db= buildDB(getApplication())
            userLD.value=db.cookingDao().showProfile(username)
            userLoadErrorLD.value=false
            loadingLD.value=false
        }
    }
    fun updateProfile(username: String,bio:String,password: String,id:Int)
    {
        launch{
            val db= buildDB(getApplication())
            db.cookingDao().updateUser(username,password,bio,id)
        }
    }
    fun addUser()
    {
        var user1= User("david","1234","Nama saya david","3","4","1","1","0","1","0","0")
        var user2= User("user1","1234","Nama saya user","5","5","1","1","1","1","1","0")
        val list= listOf(user1,user2)
        launch{
            val db= buildDB(getApplication())
            db.cookingDao().insertAllUser(*list.toTypedArray())
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}