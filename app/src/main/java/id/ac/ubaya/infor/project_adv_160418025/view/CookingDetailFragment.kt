package id.ac.ubaya.infor.project_adv_160418025.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.infor.project_adv_160418025.R
import id.ac.ubaya.infor.project_adv_160418025.util.loadImage
import id.ac.ubaya.infor.project_adv_160418025.viewmodel.CookingViewModel
import id.ac.ubaya.infor.project_adv_160418025.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_cooking_detail.*


class CookingDetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cooking_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(CookingDetailFragmentArgs.fromBundle(requireArguments()).kategori,CookingDetailFragmentArgs.fromBundle(requireArguments()).name,CookingDetailFragmentArgs.fromBundle(requireArguments()).description,
            CookingDetailFragmentArgs.fromBundle(requireArguments()).photoUrl)
        observer()
    }
    fun observer(){
        viewModel.cookingLD.observe(viewLifecycleOwner, Observer {
            txtCategory.setText(viewModel.cookingLD.value?.kategori)
            txtName.setText(viewModel.cookingLD.value?.name)
            txtDescription.setText(viewModel.cookingLD.value?.description)
            detailImageView.loadImage(viewModel.cookingLD.value?.photoUrl,progressBarDetil)
        })
    }


}