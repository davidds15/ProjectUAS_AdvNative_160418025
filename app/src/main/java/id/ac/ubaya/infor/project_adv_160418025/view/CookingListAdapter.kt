package id.ac.ubaya.infor.project_adv_160418025.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.infor.project_adv_160418025.R
import id.ac.ubaya.infor.project_adv_160418025.model.Cooking
import kotlinx.android.synthetic.main.cooking_list_item.view.*
import id.ac.ubaya.infor.project_adv_160418025.util.loadImage

class CookingListAdapter(val cookingList:ArrayList<Cooking>):RecyclerView.Adapter<CookingListAdapter.StudentViewHolder>()
{
    class StudentViewHolder(var view: View) : RecyclerView.ViewHolder(view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cooking_list_item, parent, false)
        return StudentViewHolder(view)
    }
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.txtrecipename.text = cookingList[position].kategori
        holder.view.txtName.text = cookingList[position].name
        holder.view.btnDetail.setOnClickListener {
            val action = cookingList[position].kategori?.let { it1 ->
                CookingListFragmentDirections.actionCookingListFragmentToCookingDetailFragment(
                    it1,cookingList[position].name.toString(),cookingList[position].description.toString(),cookingList[position].photoUrl.toString())
            }
            if (action != null) {
                Navigation.findNavController(it).navigate(action)
            }
        }
        holder.view.imageView.loadImage(cookingList[position].photoUrl,
            holder.view.progressBar)
    }
    override fun getItemCount(): Int {
        return cookingList.size
    }
    fun updateStudentList(newStudentList: List<Cooking>) {
        cookingList.clear()
        cookingList.addAll(newStudentList)
        notifyDataSetChanged()
    }
}