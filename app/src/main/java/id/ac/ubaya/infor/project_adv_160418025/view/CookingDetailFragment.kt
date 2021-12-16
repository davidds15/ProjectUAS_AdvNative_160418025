package id.ac.ubaya.infor.project_adv_160418025.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.infor.project_adv_160418025.R
import id.ac.ubaya.infor.project_adv_160418025.databinding.FragmentCookingDetailBinding
import id.ac.ubaya.infor.project_adv_160418025.util.loadImage
import id.ac.ubaya.infor.project_adv_160418025.viewmodel.CookingViewModel
import id.ac.ubaya.infor.project_adv_160418025.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_cooking_detail.*
import kotlinx.android.synthetic.main.fragment_cooking_list.*


class CookingDetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentCookingDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding=DataBindingUtil.inflate<FragmentCookingDetailBinding>(inflater,R.layout.fragment_cooking_detail, container, false)
        return dataBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val uuid=CookingDetailFragmentArgs.fromBundle(requireArguments()).uuid
//        Log.i("tesT",uuid.toString())


        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(uuid)
//        Log.i("testt",viewModel.cookingLD.value?.name.toString())
//        viewModel.fetch(CookingDetailFragmentArgs.fromBundle(requireArguments()).kategori,CookingDetailFragmentArgs.fromBundle(requireArguments()).name,CookingDetailFragmentArgs.fromBundle(requireArguments()).description,
//            CookingDetailFragmentArgs.fromBundle(requireArguments()).photoUrl)
        observeViewModel()
//    }

    }
    fun observeViewModel() {
        viewModel.cookingLD.observe(viewLifecycleOwner, Observer {
            dataBinding.detail=it
        })

    }


}