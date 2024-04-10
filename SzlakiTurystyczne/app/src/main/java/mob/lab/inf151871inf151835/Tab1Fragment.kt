package mob.lab.inf151871inf151835

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Tab1Fragment(private val type: Int) : Fragment() {
    interface TrailItemClickListener{
        fun onTrailItemClick(trailId: Int)
    }
    private var trailItemClickListener: TrailItemClickListener? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val trailRecycler: RecyclerView = inflater.inflate(R.layout.fragment_tab1,container,false) as RecyclerView


        val filteredTrails = Trail.trails.filter { it.getType() == type || type == 0 }
        val trailNames = Array(filteredTrails.size) { i -> filteredTrails[i].getName() }
        val trailImages = Array(filteredTrails.size) { i -> filteredTrails[i].getImageResourceId() }

        val adapter = CaptionedImagesAdapter(trailNames, trailImages)

        val layoutManager = GridLayoutManager(activity, 2)
        trailRecycler.layoutManager = layoutManager

        trailRecycler.adapter = adapter
        adapter.setListener(object : CaptionedImagesAdapter.Listener {
            override fun onClick(position: Int) {
                if(isTablet()){
                    println("tablet klikniecie---------------------------------------")
                    trailItemClickListener?.onTrailItemClick(filteredTrails[position].getId())
                    println("pozycja klikniecia: "+filteredTrails[position].getId())
                }
                else{
                    val intent = Intent(activity, TrailDetailActivity::class.java)
                    intent.putExtra("trailId", filteredTrails[position].getId())
                    activity?.startActivity(intent)
                }

            }
        })
        return trailRecycler
    }
    fun isTablet(): Boolean {
        // Implement your logic to determine if the device is a tablet
        val displayMetrics = resources.displayMetrics
        val widthDp = displayMetrics.widthPixels / displayMetrics.density
        return widthDp >= 600
    }
}