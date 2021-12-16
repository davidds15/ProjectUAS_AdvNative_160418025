package id.ac.ubaya.infor.project_adv_160418025.view

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.infor.project_adv_160418025.R
import id.ac.ubaya.infor.project_adv_160418025.model.Cooking
import id.ac.ubaya.infor.project_adv_160418025.viewmodel.CookingViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_add_recipe.*
import kotlinx.android.synthetic.main.fragment_add_recipe.btnUpdate
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import kotlinx.android.synthetic.main.fragment_login.*
import java.util.concurrent.TimeUnit


class AddRecipeFragment : Fragment() {
    private lateinit var viewModel:CookingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_recipe, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this).get(CookingViewModel::class.java)

        btnUpdate.setOnClickListener {
            var recipe= Cooking(txtkategori.text.toString(),txtrecipename.text.toString(),txtdescription.text.toString(),txturlphoto.text.toString(),"0")
            val list= listOf(recipe)
            viewModel.addRecipe(list)
            Observable.timer(0, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    MainActivity.showNotification("Add Recipe Sukses",
                        "Check Your Notification",
                        R.drawable.ic_baseline_thumb_up_24)
                }
            val action = AddRecipeFragmentDirections.addrecipetohome()
            Navigation.findNavController(it).navigate(action)
        }

    }


}