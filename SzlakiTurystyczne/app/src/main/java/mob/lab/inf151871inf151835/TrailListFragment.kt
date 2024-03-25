package mob.lab.inf151871inf151835

import android.R
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment


class TrailListFragment : ListFragment() {

    interface Listener{
        fun itemClicked(id: Long)
    }
    private var listener: Listener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        println("traillist23")
        val names = Array(Trail.trails.size) { i ->
            Trail.trails[i].getName()
        }
        println("traillist27")
        listAdapter = ArrayAdapter(inflater.context, R.layout.simple_list_item_1, names)
        setListAdapter(listAdapter)
        println("traillist31")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context){
        super.onAttach(context)
        this.listener = context as Listener
    }

    override fun onDetach(){
        super.onDetach()
        listener = null
    }

    override fun onListItemClick(listView: ListView, itemView: View, position: Int, id: Long){
        //super.onListItemClick(listView, itemView, position, id)
        //listener?.itemClicked(id)
        if (listener != null){
            listener!!.itemClicked(id)
        }
    }
}