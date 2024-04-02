package mob.lab.inf151871inf151835

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBar

class ActionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar: ActionBar? = getSupportActionBar()
        actionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}