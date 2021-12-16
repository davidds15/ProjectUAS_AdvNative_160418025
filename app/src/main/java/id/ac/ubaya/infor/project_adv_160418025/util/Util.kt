package id.ac.ubaya.infor.project_adv_160418025.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import id.ac.ubaya.infor.project_adv_160418025.R
import android.content.Context
import android.os.Build
import androidx.databinding.BindingAdapter
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import id.ac.ubaya.infor.project_adv_160418025.model.CookingDatabase

val DB_NAME="cookingdb"

fun buildDB(context:Context):CookingDatabase{
//    val db = Room.databaseBuilder(context,TodoDatabase::class.java, DB_NAME).addMigrations(Migration_1_2).build()
    val db = Room.databaseBuilder(context,CookingDatabase::class.java, DB_NAME)
        .addMigrations(Migration_1_2)
        .build()
    return db
}
val Migration_1_2=object: Migration(1,2)
{
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("create table if not exists `user` (`id` INTEGER not null,`username` TEXT,`password` TEXT not null,`Bio` TEXT, `Cooked` INTEGER, `favourite` INTEGER,`january` INTEGER, `february` INTEGER,`march` INTEGER, `april` INTEGER,`may` INTEGER,`june` INTEGER)")
    }
}
fun createNotificationChannel(context: Context, importance: Int, showBadge:
Boolean, name: String, description: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channelId = "${context.packageName}-$name"
        val channel = NotificationChannel(channelId, name, importance)
        channel.description = description
        channel.setShowBadge(showBadge)
        val notificationManager =
            context.getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }
}

@BindingAdapter("android:imageUrl","android:progressBar")
fun loadPhotoUrl(view:ImageView,url:String?,pb:ProgressBar)
{
    view.loadImage(url,pb)
}

fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object: Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }
            override fun onError(e: Exception?) {
            }
        })
}