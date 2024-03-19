package mob.lab.inf151871inf151835

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity(), TrailListFragment.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /*fun onShowDetail(view: View){
        intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }*/

    override fun itemClicked(id: Long) {
        intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_TRAIL_ID, id.toInt())
        startActivity(intent)
    }
}