package mob.lab.inf151871inf151835

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import androidx.appcompat.widget.ShareActionProvider
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import com.google.android.material.appbar.CollapsingToolbarLayout

class TrailDetailActivity : AppCompatActivity() {
    var trailId1: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trail_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)




        val trailId = intent.getIntExtra("trailId", 0)

        val trailName = Trail.trails[trailId].getName()
        trailId1 = trailId.toLong()
        toolbar.setTitle(trailName)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeButtonEnabled(true)

        val trailNameView: TextView = findViewById(R.id.trail_text)
        trailNameView.text = trailName

        val collapsingToolbarLayout: CollapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(trailName)


        val trailImage: Int = Trail.trails[trailId].getImageResourceId()
        val imageView: ImageView = findViewById(R.id.trail_image)
        imageView.setImageDrawable(ContextCompat.getDrawable(this, trailImage))
        imageView.contentDescription = trailName

        val trailLength = Trail.trails[trailId].getLength()
        val trailLengthView: TextView = findViewById(R.id.textLength)
        trailLengthView.text = "Długość Szlaku: $trailLength"

        val trailTime = TrailHelpers.timeToString(Trail.trails[trailId].getTime())
        val trailTimeView: TextView = findViewById(R.id.textTime)
        trailTimeView.text = "Czas trwania szlaku: $trailTime"

        val stoperFragment = StoperFragment().apply{
            arguments = Bundle().apply{
                putInt("trailId", trailId.toInt())
            }
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