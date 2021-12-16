package id.ac.ubaya.infor.project_adv_160418025.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.infor.project_adv_160418025.R
import id.ac.ubaya.infor.project_adv_160418025.util.loadImage
import id.ac.ubaya.infor.project_adv_160418025.viewmodel.CookingViewModel
import kotlinx.android.synthetic.main.fragment_cooking_list.*
import kotlinx.android.synthetic.main.fragment_favourite.*
import kotlinx.android.synthetic.main.fragment_favourite.progressLoad
import kotlinx.android.synthetic.main.fragment_favourite.recView
import kotlinx.android.synthetic.main.fragment_favourite.refreshLayout
import kotlinx.android.synthetic.main.fragment_favourite.textError
import kotlinx.android.synthetic.main.fragment_favourite.view.*
import kotlinx.android.synthetic.main.fragment_setting.*


class FavouriteFragment : Fragment() {


    private lateinit var viewModel: CookingViewModel
    private val cookingListAdapter = CookingListFavouriteAdapter(arrayListOf())

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

        return inflater.inflate(R.layout.fragment_cooking_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshLayout.setOnRefreshListener {
            recView.visibility = View.GONE
            textError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.fetchFavourite()
            refreshLayout.isRefreshing = false
        }
        viewModel = ViewModelProvider(this).get(CookingViewModel::class.java)
        viewModel.fetchFavourite()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = cookingListAdapter
        observeViewModel()
    }

}