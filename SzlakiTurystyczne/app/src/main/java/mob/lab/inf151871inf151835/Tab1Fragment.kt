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


class Tab1Fragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val trailRecycler: RecyclerView = inflater.inflate(R.layout.fragment_tab1,container,false) as RecyclerView
        val trailNames = Array(Trail.trails.size) { i -> Trail.trails[i].getName() }
        val trailImages = Array(Trail.trails.size) { i -> Trail.trails[i].getImageResourceId() }
        val adapter = CaptionedImagesAdapter(trailNames, trailImages)

        val layoutManager = GridLayoutManager(activity, 2)
        trailRecycler.layoutManager = layoutManager

        trailRecycler.adapter = adapter
        adapter.setListener(object : CaptionedImagesAdapter.Listener {
            override fun onClick(position: Int) {
                val intent = Intent(activity, TrailDetailActivity::class.java)
                intent.putExtra("trailId", position)
                activity?.startActivity(intent)
            }
        })
        return trailRecycler
    }
}