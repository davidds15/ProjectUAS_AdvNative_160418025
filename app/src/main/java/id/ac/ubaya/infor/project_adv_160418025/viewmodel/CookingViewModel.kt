package id.ac.ubaya.infor.project_adv_160418025.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.infor.project_adv_160418025.model.Cooking
import java.util.ArrayList

class CookingViewModel : ViewModel() {

    val cookingLD=MutableLiveData<List<Cooking>>()
    val cookingLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh()
    {
        val cooking1=Cooking("Nasi","Nasi Ayam","Ini adalah nasi ayam","https://asset.kompas.com/crops/QfT4To8L6Hh3JP5mQqLUizZuANA=/0x7:740x500/750x500/data/photo/2020/12/28/5fe9dbb116401.jpg")
        val cooking2=Cooking("Nasi","Nasi Goreng","Ini itu nasi goreng bukan nasi goyeng","https://awsimages.detik.net.id/community/media/visual/2021/08/25/resep-nasi-goreng-sosis-ala-warung-bhakti_43.jpeg?w=700&q=90")
        val cooking3=Cooking("Mie","Mie Goreng","Ini adalah mie goreng","http://kbu-cdn.com/dk/wp-content/uploads/mie-goreng-sosis.jpg")
        val cooking4=Cooking("Mie","Indomie kuah","Ini adalah indomie kuah yang dimasak pakai air","https://img-global.cpcdn.com/recipes/37d05822422c10d4/1200x630cq70/photo.jpg")

        val CookingList:ArrayList<Cooking> =arrayListOf<Cooking>(cooking1,cooking2,cooking3,cooking4)

        cookingLD.value=CookingList
        cookingLoadErrorLD.value=false
        loadingLD.value=false
    }

}