package mob.lab.inf151871inf151835

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class StoperFragment : Fragment(), View.OnClickListener{
    private var seconds = 0
    private var running = false
    private var wasRunning = false
    private var trailId = 0
    private val handler = Handler()
    private var runnable: Runnable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasRunning")
            if(wasRunning || running){
                running = true

            }
        }
        trailId = arguments?.getInt("trailId", 0) ?: 0
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("StoperFragment", "onCreateView called")


        val layout = inflater.inflate(R.layout.fragment_stoper, container, false)
        Log.d("StoperFragment", "Is running? $running")
        runStoper(layout)
        val startButton = layout.findViewById(R.id.start_button) as Button
        startButton.setOnClickListener(this)
        val stopButton = layout.findViewById(R.id.stop_button) as Button
        stopButton.setOnClickListener(this)
        val resetButton = layout.findViewById(R.id.reset_button) as Button
        resetButton.setOnClickListener(this)

        return layout
    }

    override fun onPause(){
        super.onPause()
        wasRunning = running
        val prefs = activity?.getSharedPreferences("StoperPrefs", Context.MODE_PRIVATE) ?: return
        with(prefs.edit()) {
            putInt("Seconds_$trailId", seconds)
            putBoolean("Running_$trailId", running)
            apply()
        }
    }

    override fun onResume(){
        super.onResume()
        if(wasRunning){
            running = true
        }
        val prefs = activity?.getSharedPreferences("StoperPrefs", Context.MODE_PRIVATE) ?: return
        seconds = prefs.getInt("Seconds_$trailId", 0)
        running = prefs.getBoolean("Running_$trailId", false)
        view.let{
            runStoper(it!!)}
    }
    override fun onSaveInstanceState(savedInstanceState: Bundle){
        super.onSaveInstanceState(savedInstanceState)
        running = wasRunning
        savedInstanceState.putInt("seconds", seconds)
        savedInstanceState.putBoolean("running", running)
        savedInstanceState.putBoolean("wasRunning", wasRunning)
    }
    private fun onClickStart(){
        running = true
    }
    private fun onClickStop(){
        running = false
        wasRunning = false
    }
    private fun onClickReset(){
        running = false
        seconds = 0
    }
    override fun onClick(v: View){
        when(v.id){
            R.id.start_button -> onClickStart()
            R.id.stop_button -> onClickStop()
            R.id.reset_button -> onClickReset()
        }
    }
    fun runStoper(view: View){
        val timeView = view.findViewById(R.id.time_view) as TextView
        if (runnable == null){
            runnable = object : Runnable{
                override fun run(){
                    val hours = seconds / 3600
                    val minutes = (seconds % 3600) / 60
                    val secs = seconds % 60
                    val time = String.format("%d:%02d:%02d", hours, minutes, secs)
                    timeView.setText(time)
                    if(running){
                        seconds++
                    }
                    handler.postDelayed(this, 1000)
                }
            }
        }
        handler.removeCallbacks(runnable!!)
       handler.post(runnable!!)
    }
}