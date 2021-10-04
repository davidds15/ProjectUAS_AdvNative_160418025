package id.ac.ubaya.infor.project_adv_160418025.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.infor.project_adv_160418025.model.Cooking
import id.ac.ubaya.infor.project_adv_160418025.view.CookingDetailFragmentArgs

class DetailViewModel:ViewModel() {
    val cookingLD = MutableLiveData<Cooking>()
    fun fetch(photoUrl:String?,kategori:String?,name:String?,description:String?) {
        val detailCooking1 = Cooking(kategori,name,description,photoUrl)
        cookingLD.value = detailCooking1
    }
}