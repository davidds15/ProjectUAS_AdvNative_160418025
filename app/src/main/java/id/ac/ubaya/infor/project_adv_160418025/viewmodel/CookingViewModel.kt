package id.ac.ubaya.infor.project_adv_160418025.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.infor.project_adv_160418025.model.Cooking
import id.ac.ubaya.infor.project_adv_160418025.util.buildDB

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CookingViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    private val job = Job()
    val cookingLD=MutableLiveData<List<Cooking>>()
    val cookingLoadErrorLD= MutableLiveData<Boolean>()
    val loadingLD=MutableLiveData<Boolean>()

    fun fetch ()
    {
        launch{
            val db= buildDB(getApplication())
            cookingLD.value=db.cookingDao().selectAllCooking()
            cookingLoadErrorLD.value=false
            loadingLD.value=false
        }
    }
    fun fetchFavourite()
    {
        launch{
            val db= buildDB(getApplication())
            cookingLD.value=db.cookingDao().selectFavourite()
            cookingLoadErrorLD.value=false
            loadingLD.value=false
        }
    }
    fun addRecipe(list:List<Cooking>)
    {
        launch{
            val db= buildDB(getApplication())
            db.cookingDao().insertAll(*list.toTypedArray())
        }
    }

    fun searchRecipe(name:String="%%")
    {
        launch{
            val db= buildDB(getApplication())
            db.cookingDao().searchRecipe(name)
            cookingLD.value=db.cookingDao().searchRecipe(name)
            cookingLoadErrorLD.value=false
            loadingLD.value=false
        }
    }


    //    fun update(name:String,description:String,ingredients:String,kategori:String,photo_url:String,uuid: Int)
//    {
//        launch {
//            val db = buildDB(getApplication())
//            db.cookingDao().update(name,description,ingredients,kategori,photo_url,uuid)
//        }
//    }
//
//    fun addCooking(todo:Cooking) {
//        launch {
//            val db= buildDB(getApplication())
//            db.cookingDao().insertAll(todo)
//        }
//    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

}