package mob.lab.inf151871inf151835

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
class SectionsPagerAdapter(fm: FragmentManager, private val trailItemClickListener: Tab1Fragment.TrailItemClickListener) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }
    override fun getItem(position: Int): Fragment {
        val fragment = Tab1Fragment(position)
        fragment.setTrailItemClickListener(trailItemClickListener)// Set the listener for each Tab1Fragment
        return fragment
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Wszystkie"
            1 -> "Babia Góra"
            2 -> "Polica"
            else -> null
        }
    }
}