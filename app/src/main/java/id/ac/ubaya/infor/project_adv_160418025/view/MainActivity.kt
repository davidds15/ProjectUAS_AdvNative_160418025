    package id.ac.ubaya.infor.project_adv_160418025.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import id.ac.ubaya.infor.project_adv_160418025.R
import kotlinx.android.synthetic.main.activity_main.*

    class MainActivity : AppCompatActivity() {
        private lateinit var navController: NavController
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            setSupportActionBar(findViewById(R.id.toolbar))

            val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
            navController = navHostFragment.navController
            NavigationUI.setupActionBarWithNavController(this, navController,drawerLayout)
            NavigationUI.setupWithNavController(navigationview, navController)
            bottomNavigationView.setupWithNavController(navController)
        }
        override fun onSupportNavigateUp(): Boolean {
            return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp()
        }

}