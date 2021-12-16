package id.ac.ubaya.infor.project_adv_160418025.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Cooking(
    @ColumnInfo(name="kategori")
    var kategori:String,
    @ColumnInfo(name="name")
    var name:String,
    @ColumnInfo(name="description")
    var description:String,
    @ColumnInfo(name="photo_url")
    var photo_url:String,
    @ColumnInfo(name="is_favourite")
    var is_favourite:String,
) {
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}
@Entity
data class User(
    @ColumnInfo(name="username")
    var username:String,
    @ColumnInfo(name="password")
    var password:String,
    @ColumnInfo(name="bio")
    var bio:String,
    @ColumnInfo(name="cooked")
    var cooked:String,
    @ColumnInfo(name="favourite")
    var favourite:String,
    @ColumnInfo(name="january")
    var january:String,
    @ColumnInfo(name="february")
    var february:String,
    @ColumnInfo(name="march")
    var march:String,
    @ColumnInfo(name="april")
    var april:String,
    @ColumnInfo(name="may")
    var may:String,
    @ColumnInfo(name="june")
    var june:String,
) {
    @PrimaryKey(autoGenerate = true)
    var id:Int =0
}
