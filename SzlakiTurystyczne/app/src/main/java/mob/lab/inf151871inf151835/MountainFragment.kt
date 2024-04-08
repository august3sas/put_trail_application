package mob.lab.inf151871inf151835

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class MountainFragment : Fragment() {
    fun newInstance(): MountainFragment {
        return MountainFragment()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mountain, container, false)
        return view
    }
}