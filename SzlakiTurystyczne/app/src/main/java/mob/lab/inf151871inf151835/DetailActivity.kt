package mob.lab.inf151871inf151835

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TRAIL_ID = "id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val frag = supportFragmentManager.findFragmentById(R.id.detail_frag) as TrailDetailFragment
        val trailId = intent.getIntExtra(EXTRA_TRAIL_ID, 0)
        frag.setTrail(trailId.toLong())
    }
}