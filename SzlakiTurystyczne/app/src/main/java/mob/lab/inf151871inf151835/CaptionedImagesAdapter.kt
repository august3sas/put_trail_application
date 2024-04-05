package mob.lab.inf151871inf151835

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import android.view.View;


class CaptionedImagesAdapter(private val captions: Array<String>,
                             private val imageIds: Array<Int>): RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>() {

    private lateinit var listener: Listener
    interface Listener{
        fun onClick(position: Int)
    }
    fun setListener(listener: Listener){
        this.listener = listener
    }
    class ViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView)

    override fun getItemCount(): Int{
        return captions.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaptionedImagesAdapter.ViewHolder{
        val cv = LayoutInflater.from(parent.context).inflate(R.layout.card_captioned_images, parent, false) as CardView
        return ViewHolder(cv)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val cardView = holder.cardView
        val imageView = cardView.findViewById(R.id.info_image) as ImageView

        val drawable = ContextCompat.getDrawable(cardView.context, imageIds[position])!!
        imageView.setImageDrawable(drawable)
        imageView.setContentDescription(captions[position])

        val textView = cardView.findViewById(R.id.info_text) as TextView
        textView.setText(captions[position])

        cardView.setOnClickListener { v ->
            listener?.onClick(position)
        }
    }
}