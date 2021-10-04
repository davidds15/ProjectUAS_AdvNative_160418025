package id.ac.ubaya.infor.project_adv_160418025.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.infor.project_adv_160418025.R
import kotlinx.android.synthetic.main.cooking_list_item.view.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnEditProfile.setOnClickListener {
            val action = ProfileFragmentDirections.profiletoeditprofile()
            Navigation.findNavController(it).navigate(action)
        }

        }

}