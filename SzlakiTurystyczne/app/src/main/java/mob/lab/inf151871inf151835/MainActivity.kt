package mob.lab.inf151871inf151835

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem
import androidx.core.view.MenuItemCompat
import androidx.appcompat.widget.ShareActionProvider
import androidx.viewpager.widget.ViewPager


class MainActivity : AppCompatActivity(), TrailListFragment.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val pagerAdapter: SectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        val pager: ViewPager = findViewById(R.id.pager)
        pager.setAdapter(pagerAdapter)
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

}