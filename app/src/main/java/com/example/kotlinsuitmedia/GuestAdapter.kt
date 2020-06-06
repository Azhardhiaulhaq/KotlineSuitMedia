package com.example.kotlinsuitmedia

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinsuitmedia.model.Guest

class GuestAdapter constructor(val act : Activity, val data : List<Guest>?) : RecyclerView.Adapter<GuestAdapter.ViewHolder>() {
    val mActivity : Activity
    val mData : List<Guest>?
    init {
        mActivity = act
        mData = data
    }


    override fun getItemCount(): Int = mData!!.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val item = mData?.get(position)
        holder.tvGuestName.text = item!!.name
        val birthDate : String = item!!.birthdate
        val birth =
            birthDate.split("-".toRegex(), 3).toTypedArray()
        val month : String = birth[1]
        if (isPrime(month.toInt())!!) {
            holder.tvMonth.text = "The Month is Prime"
        } else {
            holder.tvMonth.text = "The Month is not Prime"
        }
        holder.guestDetailCL.setOnClickListener(
            object : View.OnClickListener{
                override fun onClick(v : View?){
                    val sendGuestIntent = Intent(holder.tvGuestName.context, SelectEventAndGuestActivity::class.java).apply{
                        putExtra("guestID",item!!.id)
                        putExtra("guestName",item!!.name)
                        putExtra("guestBirthDate",item!!.birthdate)
                    }
                    mActivity.setResult(Activity.RESULT_OK,sendGuestIntent)
                    mActivity.finish()
                }
            })

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): ViewHolder{
        return ViewHolder.from(parent)
    }

    fun isPrime(number: Int): Boolean? {
        var isprime = false
        var i = 2
        while (i <= number / 2){
            if (number % i == 0){
                isprime = true
                break
            }
            ++i
        }
        return isprime
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvGuestName : TextView = itemView.findViewById(R.id.guestNameTV)
        val tvMonth : TextView = itemView.findViewById(R.id.monthTV)
        val guestDetailCL : ConstraintLayout = itemView.findViewById(R.id.guestDetailCL)



        companion object {
            fun from (parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.activity_guest_item,parent,false)

                return ViewHolder(view)
            }
        }

    }
}