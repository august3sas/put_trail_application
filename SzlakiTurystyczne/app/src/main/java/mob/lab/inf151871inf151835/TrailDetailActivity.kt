package mob.lab.inf151871inf151835

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class TrailDetailActivity : AppCompatActivity() {
    var trailId1: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trail_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val trailId = intent.getIntExtra("trailId", 0)

        val trailName = Trail.trails[trailId].getName()
        trailId1 = trailId.toLong()
        val trailNameView: TextView = findViewById(R.id.trail_text)
        trailNameView.text = trailName

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
}