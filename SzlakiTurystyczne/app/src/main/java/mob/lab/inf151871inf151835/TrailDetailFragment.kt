package mob.lab.inf151871inf151835

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.ListFragment
import com.google.android.material.appbar.CollapsingToolbarLayout

class TrailDetailFragment : Fragment() {
    private var trailId: Long = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater.inflate(R.layout.fragment_trail_detail, container, false)

        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val trailId = arguments?.getInt("trailId", 0) ?: 0

        val trailName = Trail.trails[trailId].getName()
        toolbar.title = trailName

        val trailNameView: TextView = view.findViewById(R.id.trail_text)
        trailNameView.text = trailName

        val collapsingToolbarLayout: CollapsingToolbarLayout = view.findViewById(R.id.collapsing_toolbar)
        collapsingToolbarLayout.title = trailName

        val trailImage: Int = Trail.trails[trailId].getImageResourceId()

        val imageView: ImageView = view.findViewById(R.id.trail_image)
        imageView.setImageDrawable(ContextCompat.getDrawable(requireContext(), trailImage))
        imageView.contentDescription = trailName

        val trailLength = Trail.trails[trailId].getLength()
        val trailLengthView: TextView = view.findViewById(R.id.textLength)
        trailLengthView.text = "Długość Szlaku: $trailLength"

        val trailTime = TrailHelpers.timeToString(Trail.trails[trailId].getTime())
        val trailTimeView: TextView = view.findViewById(R.id.textTime)
        trailTimeView.text = "Czas trwania szlaku: $trailTime"

        val trailStages: ListView = view.findViewById(R.id.trail_stages)
        Trail.stagesToListViewParser(Trail.trails[trailId],trailStages)

        val stoperFragment = StoperFragment().apply {
            arguments = Bundle().apply {
                putInt("trailId", trailId)
            }
        }
        return view
    }

    override fun onStart(){
        super.onStart()
        updateTrailInfo(trailId)
    }
    public fun setTrail(trailId: Long){
        this.trailId = trailId ?: 0
        updateTrailInfo(trailId)
    }
    fun updateTrailInfo(trailId: Long){
        val view = view
        if(view != null){
            val trail = Trail.trails[trailId.toInt()]

            val name = view.findViewById(R.id.trail_text) as TextView
            name.text = trail.getName()

            val trailImage: Int = Trail.trails[trailId.toInt()].getImageResourceId()

            val imageView: ImageView = view.findViewById(R.id.trail_image)
            imageView.setImageDrawable(ContextCompat.getDrawable(requireContext(), trailImage))
            imageView.contentDescription = trail.getName()

            val toolbar: Toolbar = view.findViewById(R.id.toolbar)
            toolbar.title = trail.getName()

            val collapsingToolbarLayout: CollapsingToolbarLayout = view.findViewById(R.id.collapsing_toolbar)
            collapsingToolbarLayout.title = trail.getName()

            val length = view.findViewById(R.id.textLength) as TextView
            length.text = "Długość Szlaku: "+trail.getLength().toString()
            println(length.text)

            val time = view.findViewById(R.id.textTime) as TextView
            time.text = "Czas trwania szlaku: "+TrailHelpers.timeToString(trail.getTime())
            println(time.text)

            val trailStages: ListView = view.findViewById(R.id.trail_stages)
            Trail.stagesToListViewParser(Trail.trails[trailId.toInt()],trailStages)

        }
    }
}