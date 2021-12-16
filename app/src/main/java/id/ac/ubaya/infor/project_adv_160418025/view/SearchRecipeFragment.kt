package id.ac.ubaya.infor.project_adv_160418025.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.infor.project_adv_160418025.R
import id.ac.ubaya.infor.project_adv_160418025.databinding.FragmentProfileBinding
import id.ac.ubaya.infor.project_adv_160418025.databinding.FragmentSearchRecipeBinding
import id.ac.ubaya.infor.project_adv_160418025.util.loadImage
import id.ac.ubaya.infor.project_adv_160418025.viewmodel.CookingViewModel
import kotlinx.android.synthetic.main.fragment_cooking_list.*
import kotlinx.android.synthetic.main.fragment_search_recipe.*
import kotlinx.android.synthetic.main.fragment_search_recipe.progressLoad
import kotlinx.android.synthetic.main.fragment_search_recipe.recView
import kotlinx.android.synthetic.main.fragment_search_recipe.textError


class SearchRecipeFragment : Fragment() {

    private lateinit var viewModel: CookingViewModel
    private val cookingListAdapter = CookingListSearchAdapter(arrayListOf())
    private lateinit var dataBinding: FragmentSearchRecipeBinding

    fun observeViewModel() {
        viewModel.cookingLD.observe(viewLifecycleOwner, Observer {
            cookingListAdapter.updateCookingList(it)
        })
        viewModel.cookingLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it) {
                textError.visibility = View.VISIBLE
            } else {
                textError.visibility = View.GONE
            }
        })
        viewModel.cookingLD.observe(viewLifecycleOwner, Observer {
            if(it.isEmpty()) {
                recView.visibility = View.GONE
                progressLoad.visibility = View.VISIBLE
            } else {
                recView.visibility = View.VISIBLE
                progressLoad.visibility = View.GONE
            }
        })
        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it) {
                textError.visibility = View.VISIBLE
            } else {
                textError.visibility = View.GONE
            }
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding= DataBindingUtil.inflate<FragmentSearchRecipeBinding>(inflater,R.layout.fragment_search_recipe, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshLayoutsearch.setOnRefreshListener {
            recView.visibility = View.GONE
            textError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.searchRecipe()
            refreshLayoutsearch.isRefreshing = false
        }
        viewModel = ViewModelProvider(this).get(CookingViewModel::class.java)
        viewModel.fetch()
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = cookingListAdapter
        observeViewModel()
        txtSearch.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                viewModel.searchRecipe("%"+s+"%")
                recView.layoutManager = LinearLayoutManager(context)
                recView.adapter = cookingListAdapter
                observeViewModel()
            }
        })



    }

}