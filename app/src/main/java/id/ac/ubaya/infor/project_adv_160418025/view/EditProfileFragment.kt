package id.ac.ubaya.infor.project_adv_160418025.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.infor.project_adv_160418025.R
import id.ac.ubaya.infor.project_adv_160418025.databinding.FragmentEditProfileBinding
import id.ac.ubaya.infor.project_adv_160418025.databinding.FragmentProfileBinding
import id.ac.ubaya.infor.project_adv_160418025.viewmodel.UserViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import kotlinx.android.synthetic.main.fragment_profile.*
import java.util.concurrent.TimeUnit

class EditProfileFragment : Fragment(),ButtonUpdateClickListener {


    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding: FragmentEditProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding= DataBindingUtil.inflate<FragmentEditProfileBinding>(inflater,R.layout.fragment_edit_profile, container, false)
        return dataBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.listener=this
    viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
//        viewModel.addUser()
    viewModel.showProfile()
//        Log.i("profile",viewModel.userLD.value?.username.toString())
//        Log.i("testt",viewModel.cookingLD.value?.name.toString())
//        viewModel.fetch(CookingDetailFragmentArgs.fromBundle(requireArguments()).kategori,CookingDetailFragmentArgs.fromBundle(requireArguments()).name,CookingDetailFragmentArgs.fromBundle(requireArguments()).description,
//            CookingDetailFragmentArgs.fromBundle(requireArguments()).photoUrl)
    observeViewModel()
//    }

}
fun observeViewModel() {
    viewModel.userLD.observe(viewLifecycleOwner, Observer {
        dataBinding.user=it
    })

}

    override fun ButtonUpdateClickListener(v: View) {
        var username=txtUsername.text.toString()
        var bio=txtBio.text.toString()
        var password=txtPassword.text.toString()
        val id=EditProfileFragmentArgs.fromBundle(requireArguments()).id
        viewModel.updateProfile(username,bio,password,id)
        Observable.timer(0, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                MainActivity.showNotification("Edit Profile Sukses",
                    "Check Your Notification",
                    R.drawable.ic_baseline_thumb_up_24)
            }
            val action = EditProfileFragmentDirections.editprofiletoprofile()
            Navigation.findNavController(v).navigate(action)
    }


}