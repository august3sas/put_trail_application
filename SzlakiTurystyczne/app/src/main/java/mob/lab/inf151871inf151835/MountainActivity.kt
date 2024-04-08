package mob.lab.inf151871inf151835

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MountainActivity : SingleFragmentActivity() {
    override fun createFragment(): androidx.fragment.app.Fragment {
        return MountainFragment()
    }
}