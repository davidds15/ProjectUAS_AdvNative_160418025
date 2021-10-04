package id.ac.ubaya.infor.project_adv_160418025.model

import com.google.gson.annotations.SerializedName

data class Cooking(
    val kategori    :String?,
    @SerializedName("recipe_name")
    val name:String?,
    @SerializedName("description")
    val description:String?,
    @SerializedName("photo_url")
    val photoUrl:String?
)