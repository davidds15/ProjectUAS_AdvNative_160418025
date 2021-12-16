package id.ac.ubaya.infor.project_adv_160418025.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.infor.project_adv_160418025.R
import id.ac.ubaya.infor.project_adv_160418025.databinding.CookingListItemBinding
import id.ac.ubaya.infor.project_adv_160418025.model.Cooking
import kotlinx.android.synthetic.main.cooking_list_item.view.*
import id.ac.ubaya.infor.project_adv_160418025.util.loadImage

class CookingListSearchAdapter(val cookingList:ArrayList<Cooking>):RecyclerView.Adapter<CookingListSearchAdapter.CookingViewHolder>(),ButtonDetailClickListener {
    class CookingViewHolder(var view: CookingListItemBinding) : RecyclerView.ViewHolder(view.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):CookingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<CookingListItemBinding>(inflater,R.layout.cooking_list_item,parent,false)
        return CookingViewHolder(view)
    }
    override fun onBindViewHolder(holder: CookingViewHolder, position: Int) {
        holder.view.cooking=cookingList[position]
        holder.view.listener=this
    }
    override fun getItemCount(): Int {
        return cookingList.size
    }
    fun updateCookingList(newStudentList: List<Cooking>) {
        cookingList.clear()
        cookingList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val action =
            SearchRecipeFragmentDirections.actionSearchRecipeFragmentToCookingDetailFragment(v.tag.toString().toInt())
        Navigation.findNavController(v).navigate(action)
    }


}