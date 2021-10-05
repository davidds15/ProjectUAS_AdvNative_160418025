package id.ac.ubaya.infor.project_adv_160418025.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.ubaya.infor.project_adv_160418025.R
import id.ac.ubaya.infor.project_adv_160418025.util.loadImage
import kotlinx.android.synthetic.main.fragment_search_recipe.*


class SearchRecipeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageviewnasiayam.loadImage("https://asset.kompas.com/crops/QfT4To8L6Hh3JP5mQqLUizZuANA=/0x7:740x500/750x500/data/photo/2020/12/28/5fe9dbb116401.jpg",progressLoadSearch)
        imageViewNasiGoreng.loadImage("https://awsimages.detik.net.id/community/media/visual/2021/08/25/resep-nasi-goreng-sosis-ala-warung-bhakti_43.jpeg?w=700&q=90",progressLoadSearch)
        imageviewMieGoreng.loadImage("http://kbu-cdn.com/dk/wp-content/uploads/mie-goreng-sosis.jpg",progressLoadSearch)
        imageviewindomie.loadImage("https://img-global.cpcdn.com/recipes/37d05822422c10d4/1200x630cq70/photo.jpg",progressLoadSearch)



    }
}