package mob.lab.inf151871inf151835

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class MountainFragment : Fragment() {
    fun newInstance(): MountainFragment {
        return MountainFragment()
    }
    var mSceneView: View? = null
    var mMountainView: View? = null
    var mSkyView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mountain, container, false)
        mSceneView = view
        mMountainView = view.findViewById(R.id.mountain)
        mSkyView = view.findViewById(R.id.sky)
        mSceneView!!.setOnClickListener(View.OnClickListener { startAnimation() })
        return view
    }

    fun startAnimation(){
        val mountainYStart = mMountainView!!.getTop()
        val mountainYEnd = mSkyView!!.getHeight()
        val heightAnimator = ObjectAnimator.ofFloat(mMountainView, "y", mountainYStart.toFloat(), mountainYEnd.toFloat())
        heightAnimator.start()
    }
}