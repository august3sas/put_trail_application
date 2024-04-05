package mob.lab.inf151871inf151835

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class TrailDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trail_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val trailId = intent.getIntExtra("trailId", 0)
        val trailName = Trail.trails[trailId].getName()

        val textView: TextView = findViewById(R.id.trail_text)
        textView.text = trailName

        val trailImage: Int = Trail.trails[trailId].getImageResourceId()
        val imageView: ImageView = findViewById(R.id.trail_image)
        imageView.setImageDrawable(ContextCompat.getDrawable(this, trailImage))
        imageView.contentDescription = trailName

    }
}