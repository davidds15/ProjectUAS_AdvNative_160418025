    package id.ac.ubaya.infor.project_adv_160418025.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import id.ac.ubaya.infor.project_adv_160418025.R
import id.ac.ubaya.infor.project_adv_160418025.util.createNotificationChannel
import kotlinx.android.synthetic.main.activity_main.*

    class MainActivity : AppCompatActivity() {
        private lateinit var navController: NavController
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            setSupportActionBar(findViewById(R.id.toolbar))

            val navHostFragment = supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment
            navController = navHostFragment.navController
            NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
            NavigationUI.setupWithNavController(navigationview, navController)
            bottomNavigationView.setupWithNavController(navController)
            createNotificationChannel(this,
                NotificationManagerCompat.IMPORTANCE_DEFAULT, false,
                getString(R.string.app_name), "App notification channel.")
        }
        override fun onSupportNavigateUp(): Boolean {
            return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp()
        }
        init {
            instance = this
        }
        companion object {
            private var instance:MainActivity ?= null

            fun showNotification(title:String, content:String, icon:Int) {
                val channelId =
                    "${instance?.packageName}-${instance?.getString(R.string.app_name)}"
                val notificationBuilder =
                    NotificationCompat.Builder(
                        instance!!.applicationContext,
                        channelId
                    ).apply {
                        setSmallIcon(icon)
                        setContentTitle(title)
                        setContentText(content)
                        setStyle(NotificationCompat.BigTextStyle())
                        priority = NotificationCompat.PRIORITY_DEFAULT
                        setAutoCancel(true)
                    }
                val notificationManager =
                    NotificationManagerCompat.from(instance!!.applicationContext.applicationContext!!)
                notificationManager.notify(1001, notificationBuilder.build())
            }
        }

}
