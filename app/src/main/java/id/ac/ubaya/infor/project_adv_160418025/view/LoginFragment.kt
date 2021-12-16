package id.ac.ubaya.infor.project_adv_160418025.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.infor.project_adv_160418025.R
import id.ac.ubaya.infor.project_adv_160418025.viewmodel.DetailViewModel
import id.ac.ubaya.infor.project_adv_160418025.viewmodel.UserViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_cooking_list.*
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import kotlinx.android.synthetic.main.fragment_login.*
import java.util.concurrent.TimeUnit
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers


class LoginFragment : Fragment() {

    private lateinit var viewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        btnUpdate2.setOnClickListener {
            var username=txtUsernameLogin.text.toString()
            var password=txtPasswordLogin.text.toString()
            viewModel.fetch(username,password)
            Log.i("username",username)
            Log.i("password",password)
            Log.i("LD",viewModel.userLD.value?.username.toString())
//            observeViewModel()
            if(viewModel.userLD.value?.username==username) {
                val action = LoginFragmentDirections.logintohome()
                Navigation.findNavController(it).navigate(action)
                Observable.timer(0, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        MainActivity.showNotification("Login Sukses",
                            "Check Your Notification",
                            R.drawable.ic_baseline_thumb_up_24)
                    }
            }
            else if(viewModel.userLD.value?.username!=username){
                Toast.makeText(view.context,"Login Gagal !",Toast.LENGTH_LONG).show()
            }
            else if(viewModel.userLD.value?.username==null)
            {

            }


        }

        }
//    fun observeViewModel() {
//        viewModel.cookingLD.observe(viewLifecycleOwner, Observer {
//        })

    }


