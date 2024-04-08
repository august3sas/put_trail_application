package mob.lab.inf151871inf151835

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

abstract class SingleFragmentActivity : AppCompatActivity() {

    protected abstract fun createFragment(): androidx.fragment.app.Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_fragment)
        val fm = supportFragmentManager
        var fragment = fm.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            fragment = createFragment()
            fm.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}