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

class ListViewModel(application: Application): AndroidViewModel(application) {
    val TAG = "volleyTag"
    private var queue: RequestQueue?= null
    val studentsLD = MutableLiveData<List<Cooking>>()
    val studentLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    fun refresh() {
        loadingLD.value = true
        studentLoadErrorLD.value = false
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                loadingLD.value = false
                val sType = object : TypeToken<List<Cooking>>() { }.type
                val result = Gson().fromJson<List<Cooking>>(response, sType)
                studentsLD.value = result
                loadingLD.value = false
            },
            {
                studentLoadErrorLD.value = false
                loadingLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}