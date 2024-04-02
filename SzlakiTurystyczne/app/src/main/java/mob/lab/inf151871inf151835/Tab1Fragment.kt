package mob.lab.inf151871inf151835

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment


class Tab1Fragment : ListFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            inflater.context,
            android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.kategoria1)
        )
        setListAdapter(adapter)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}