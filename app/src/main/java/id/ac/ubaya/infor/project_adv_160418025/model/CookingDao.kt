package id.ac.ubaya.infor.project_adv_160418025.model
import androidx.room.*

@Dao
interface CookingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg todo:Cooking)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUser(vararg todo:User)

    @Query("SELECT * FROM cooking")
    suspend fun selectAllCooking(): List<Cooking>

    @Query("SELECT * FROM cooking where is_favourite=1")
    suspend fun selectFavourite(): List<Cooking>

    @Query("SELECT * FROM cooking WHERE uuid= :id")
    suspend fun selectCooking(id:Int): Cooking

    @Query("SELECT * FROM cooking WHERE name like :name")
    suspend fun searchRecipe(name:String): List<Cooking>

    @Query("UPDATE cooking SET name= :name,description=:description,kategori=:kategori,photo_url=:photo_url WHERE uuid=:uuid")
    suspend fun update(name:String,description:String,kategori:String,photo_url:String,uuid:Int)

    @Query("SELECT * FROM user where username=:username and password=:password")
    suspend fun selectUser(username:String,password:String): User

    @Query("SELECT * FROM user where username=:username")
    suspend fun showProfile(username: String): User


    @Query("UPDATE user SET username= :username,password=:password,bio=:bio WHERE id=:id")
    suspend fun updateUser(username:String,password:String,bio:String,id: Int)

    @Delete
    suspend fun deleteTodo(cooking: Cooking)
}