package mob.lab.inf151871inf151835

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem
import androidx.core.view.MenuItemCompat
import androidx.appcompat.widget.ShareActionProvider
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.snackbar.Snackbar;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.splashscreen.SplashScreen
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView


import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity(), TrailListFragment.Listener, NavigationView.OnNavigationItemSelectedListener {
    private var keepSplash = true
    private val delay = 1200L
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val drawer: DrawerLayout = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.open_drawer,R.string.close_drawer)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        setSupportActionBar(toolbar)

        val pagerAdapter: SectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        val pager: ViewPager = findViewById(R.id.pager)
        pager.setAdapter(pagerAdapter)

        val tabLayout: TabLayout = findViewById(R.id.tabs)
        tabLayout.setupWithViewPager(pager)
    }

    fun onShowDetail(view: View){
        intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }

    override fun itemClicked(id: Long) {
        val trailDetailsFragment = supportFragmentManager.findFragmentById(R.id.detail_frag) as? TrailDetailFragment

        if (trailDetailsFragment != null) {
            // Jeśli fragment jest już wyświetlony, przekaż mu identyfikator szlaku
            trailDetailsFragment.setTrail(id.toLong())
        } else {
            // Jeśli fragment nie jest wyświetlony, utwórz nową intencję z dodatkami i uruchom aktywność
            intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_TRAIL_ID, id.toInt())
            startActivity(intent)
        }
    }
    fun setShareActionIntent(text: String, shareActionProvider: ShareActionProvider){
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, text)
        //val menuItem: MenuItem = findViewById(R.id.action_share)
        //val shareActionProvider: ShareActionProvider = MenuItemCompat.getActionProvider(menuItem) as ShareActionProvider
        shareActionProvider.setShareIntent(intent)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        val menuItem: MenuItem? = menu?.findItem(R.id.action_share)
        val shareActionProvider: ShareActionProvider = MenuItemCompat.getActionProvider(menuItem!!) as ShareActionProvider
        setShareActionIntent("words come easy", shareActionProvider)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.getItemId()) {
            R.id.action_action -> {
                // Code executed when the action_create_order item is clicked
                val intent = Intent(this, ActionActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        var fragment: Fragment? = null
        var intent: Intent? = null
        when (id) {
            R.id.nav_import -> {
                fragment = TopFragment()
            }
            R.id.nav_gallery -> {
                fragment = TopFragment()
            }
            R.id.nav_slideshow -> {
                fragment = TopFragment()
            }
            R.id.nav_tools -> {
                fragment = TopFragment()
            }
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit()
        }else{
            startActivity(intent)
        }
        val drawer: DrawerLayout = findViewById(R.id.drawer_layout)
        drawer.closeDrawers()
        return true
    }
    override fun onBackPressed(){
        val drawer: DrawerLayout = findViewById(R.id.drawer_layout)
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
    fun onClickDone(view: View){
        val text: CharSequence = "Hektor miał Trojan radę nad Skamandru rzeką."
        val duration = Toast.LENGTH_SHORT
        val snackbar = Snackbar.make(findViewById(R.id.coordinator), text, duration)
        snackbar.setAction("Cofnij") {
            Toast.makeText(this@MainActivity, "Cofnięto!", Toast.LENGTH_SHORT).show()
        }
        snackbar.show()
    }
    private fun setupSplashScreen(splashScreen: SplashScreen) {
        // Replace this timer with your logic to load data on the splash screen.
        splashScreen.setKeepOnScreenCondition { keepSplash }
        Handler(Looper.getMainLooper()).postDelayed({
            keepSplash = false
        }, delay)
    }
}