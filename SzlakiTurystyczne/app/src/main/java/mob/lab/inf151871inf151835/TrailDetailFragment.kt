package mob.lab.inf151871inf151835

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.ListFragment

class TrailDetailFragment : ListFragment() {
    private var trailId: Long = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
       return inflater.inflate(R.layout.fragment_trail_detail, container, false)
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

            val name = view.findViewById(R.id.textName) as TextView
            name.text = trail.getName()
            println(name.text)
            println("26")

            val length = view.findViewById(R.id.textLength) as TextView
            length.text = "Długość Szlaku: "+trail.getLength().toString()
            println(length.text)
            println("30")

            val time = view.findViewById(R.id.textTime) as TextView
            time.text = "Czas trwania szlaku: "+TrailHelpers.timeToString(trail.getTime())
            println(time.text)
            println("37")
        }
    }

}