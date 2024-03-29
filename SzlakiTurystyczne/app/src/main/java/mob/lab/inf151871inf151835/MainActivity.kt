package mob.lab.inf151871inf151835

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity(), TrailListFragment.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("main 12")
        setContentView(R.layout.activity_main)
        println("main 14")
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
}