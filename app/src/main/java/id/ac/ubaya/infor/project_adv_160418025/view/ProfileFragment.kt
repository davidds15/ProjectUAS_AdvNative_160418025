package id.ac.ubaya.infor.project_adv_160418025.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.infor.project_adv_160418025.R
import id.ac.ubaya.infor.project_adv_160418025.databinding.FragmentCookingDetailBinding
import id.ac.ubaya.infor.project_adv_160418025.databinding.FragmentProfileBinding
import id.ac.ubaya.infor.project_adv_160418025.viewmodel.DetailViewModel
import id.ac.ubaya.infor.project_adv_160418025.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.cooking_list_item.view.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(),ButtonEditProfileClickListener {

    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding= DataBindingUtil.inflate<FragmentProfileBinding>(inflater,R.layout.fragment_profile, container, false)
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

    override fun ButtonEditProfileClickListener(v: View) {
        val action = ProfileFragmentDirections.profiletoeditprofile(v.tag.toString().toInt())
        Navigation.findNavController(v).navigate(action)
    }

}