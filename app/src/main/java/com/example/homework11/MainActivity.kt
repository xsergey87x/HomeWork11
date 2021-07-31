package com.example.homework11


import android.os.Bundle
import android.app.Activity
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import android.content.Context
import android.content.Intent
import androidx.viewpager2.widget.ViewPager2
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var viewPager2: ViewPager2
    //lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.view_pager)
        viewPager2.adapter = SampleAdapter(this)

        val tabs: TabLayout = findViewById(R.id.tabs)

        TabLayoutMediator(tabs, viewPager2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> { tab.text = "TAB ONE"}
                    1 -> { tab.text = "TAB TWO"}
                }
            }).attach()




        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
              when (item.itemId) {
            R.id.setting -> {

                val login = 123
                val password = 123
                    Storage.status = "logined"
                    val params = bundleOf(
                        "login" to login.toString(),
                        "password" to password.toString()
                    )
                    openNextActivity(SettingsActivity::class.java, params)

                return true
            }
            R.id.help -> {
                //text_view.text = "Copy"
                return true
            }
            R.id.about -> {
               /// text_view.text = "Paste"
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }


    }

class SampleAdapter(activity: MainActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> throw IllegalArgumentException("Only 2 tabs")
        }
    }

}

fun openNextActivity(clazz: Class<out Activity>, params: Bundle) {
    val intent = Intent(App.appContext, clazz).apply {
        putExtras(params)
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
    App.appContext.startActivity(intent)
}

class Storage {

    companion object {
        var status: String? = null
    }

}