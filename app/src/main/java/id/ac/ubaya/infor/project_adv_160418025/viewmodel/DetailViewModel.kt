package id.ac.ubaya.infor.project_adv_160418025.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.infor.project_adv_160418025.model.Cooking
import id.ac.ubaya.infor.project_adv_160418025.util.buildDB
import id.ac.ubaya.infor.project_adv_160418025.view.CookingDetailFragmentArgs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    private val job = Job()
    val cookingLD=MutableLiveData<Cooking>()
    val cookingLoadErrorLD= MutableLiveData<Boolean>()
    val loadingLD=MutableLiveData<Boolean>()

    fun fetch (uuid:Int)
    {
        launch{
            val db= buildDB(getApplication())
            cookingLD.value=db.cookingDao().selectCooking(uuid)
            cookingLoadErrorLD.value=false
            loadingLD.value=false
        }
    }
    fun update(name:String,description:String,ingredients:String,kategori:String,photo_url:String,uuid: Int)
    {
        launch {
            val db = buildDB(getApplication())
            db.cookingDao().update(name,description,kategori,photo_url,uuid)
        }
    }

    fun addCooking(cooking: Cooking) {
        launch {
            val db= buildDB(getApplication())
            db.cookingDao().insertAll(cooking)
        }
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

}