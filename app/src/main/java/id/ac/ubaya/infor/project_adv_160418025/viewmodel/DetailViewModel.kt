package id.ac.ubaya.infor.project_adv_160418025.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.infor.project_adv_160418025.model.Cooking
//import id.ac.ubaya.infor.project_adv_160418025.view.StudentDetailFragmentArgs

class DetailViewModel:ViewModel() {
    val studentLD = MutableLiveData<Cooking>()
    fun fetch(id: String?,name:String?,description:String?,photoUrl:String?) {
        val student1 = Cooking(id,name,description,photoUrl)
        studentLD.value = student1
    }
}