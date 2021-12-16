package id.ac.ubaya.infor.project_adv_160418025.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.ubaya.infor.project_adv_160418025.util.Migration_1_2

@Database(entities = arrayOf(Cooking::class,User::class), version = 2)
abstract class CookingDatabase: RoomDatabase() {
    abstract fun cookingDao(): CookingDao

    companion object {
        @Volatile private var instance: CookingDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CookingDatabase::class.java,
                "cookingdb").build()
//                "tododb").addMigrations(Migration_1_2).build()
        operator fun invoke(context:Context) {
            if(instance!=null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }

    }

}