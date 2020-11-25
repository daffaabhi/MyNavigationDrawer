package com.example.mynavigationdrawer

import android.os.Bundle
import android.view.Menu
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    internal lateinit var profileCircleImageView: CircleImageView
    internal var profileImageUrl = "https://scontent-sin6-1.cdninstagram.com/v/t51.2885-19/s150x150/123936374_420239505808129_8938757920873434002_n.jpg?_nc_ht=scontent-sin6-1.cdninstagram.com&_nc_cat=101&_nc_ohc=JTWUBKQfxKwAX87PTKg&tp=1&oh=fef784cf93bf9e5b5d7e0ed539ff26cb&oe=5FE8D027"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        profileCircleImageView = navView.getHeaderView(0).findViewById(R.id.imageView)
        Glide.with(this)
            .load(profileImageUrl)
            .into(profileCircleImageView)
        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
            R.id.nav_tools, R.id.nav_share, R.id.nav_send, R.id.nav_cart)
            .setDrawerLayout(drawerLayout)
            .build()

        val navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}