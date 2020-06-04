package com.example.kotlinsuitmedia

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinsuitmedia.network.EventsProperty
import com.example.kotlinsuitmedia.network.GuestProperty
import com.squareup.picasso.Picasso

class EventsAdapter constructor(val act : Activity) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {
    val mActivity : Activity
    init {
        mActivity = act
    }

    var data = listOf<EventsProperty>()

    override fun getItemCount() = data.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val item = data[position]
        holder.tvEventName.text = item.name
        holder.tvEventDate.text = item.date
        holder.tvEventDesc.text = item.description
        val picasso = Picasso.get()
        picasso.load(item.url)
        .placeholder(R.drawable.ic_baseline_adb_24).into(holder.ivEvent)
        holder.eventConstraintLayout.setOnClickListener(
            object : View.OnClickListener{
                override fun onClick(v : View?){
                    val sendEventIntent = Intent(holder.tvEventName.context, SelectEventAndGuestActivity::class.java).apply{
                        putExtra("eventName",item.name)
                        putExtra("eventDate",item.date)
                    }
                    mActivity.setResult(Activity.RESULT_OK,sendEventIntent)
                    mActivity.finish()
                }
            })
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): ViewHolder{
        return ViewHolder.from(parent)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvEventName : TextView = itemView.findViewById(R.id.eventsNameTV)
        val tvEventDate : TextView = itemView.findViewById(R.id.eventsDateTV)
        val eventConstraintLayout : ConstraintLayout = itemView.findViewById(R.id.eventsCL)
        val ivEvent : ImageView = itemView.findViewById(R.id.eventsIV)
        val tvEventDesc : TextView = itemView.findViewById(R.id.eventDescriptionTV)

        companion object {
            fun from (parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.activity_events_item,parent,false)

                return ViewHolder(view)
            }
        }

    }
}