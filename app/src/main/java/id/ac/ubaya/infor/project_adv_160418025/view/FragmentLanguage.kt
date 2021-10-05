package id.ac.ubaya.infor.project_adv_160418025.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.infor.project_adv_160418025.R
import kotlinx.android.synthetic.main.fragment_language.*
import kotlinx.android.synthetic.main.fragment_login.*


class FragmentLanguage : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_language, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView6.setImageResource(R.drawable.indo)
        imageView7.setImageResource(R.drawable.china)
        imageView8.setImageResource(R.drawable.vietnam)
        imageView9.setImageResource(R.drawable.thai)
        imageView10.setImageResource(R.drawable.russian)

        cardviewrussian.setOnClickListener {
            val action = FragmentLanguageDirections.languagetohome()
            Navigation.findNavController(it).navigate(action)
        }
        cardviewthai.setOnClickListener {
            val action = FragmentLanguageDirections.languagetohome()
            Navigation.findNavController(it).navigate(action)
        }
        cardView2.setOnClickListener {
            val action = FragmentLanguageDirections.languagetohome()
            Navigation.findNavController(it).navigate(action)
        }
        cardView4.setOnClickListener {
            val action = FragmentLanguageDirections.languagetohome()
            Navigation.findNavController(it).navigate(action)
        }
        cardviewabout.setOnClickListener {
            val action = FragmentLanguageDirections.languagetohome()
            Navigation.findNavController(it).navigate(action)
        }
        cardViewsetting.setOnClickListener {
            val action = FragmentLanguageDirections.languagetohome()
            Navigation.findNavController(it).navigate(action)
        }

    }

}