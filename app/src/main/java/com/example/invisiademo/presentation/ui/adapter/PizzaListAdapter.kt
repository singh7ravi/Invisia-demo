package com.example.myapplication.presentation.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.invisiademo.R
import com.example.myapplication.presentation.ui.listeners.OnListItemCliclkListener
import com.example.myapplication.presentation.ui.model.ListItem

class PizzaListAdapter (private val items: List<ListItem>) :
    RecyclerView.Adapter<PizzaListAdapter.CustomItemViewHolder>() {

    private var onClickListener: OnListItemCliclkListener? = null

    class CustomItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.pizzaImg)
        val itemName: TextView = itemView.findViewById(R.id.pizzaType)
        val rowItem: CardView = itemView.findViewById(R.id.rowCl)
    }

    fun setOnClickListener(onClickListener: OnListItemCliclkListener) {
        this.onClickListener = onClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return CustomItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomItemViewHolder, position: Int) {
        val item = items[position]
        holder.itemImage.setImageResource(item.imageResId)
        holder.itemName.text = item.name
        holder.rowItem.setOnClickListener {
            Log.d("+++++++++++++++++", "inside position $position")
            if(onClickListener != null) {
                onClickListener!!.onClickItem(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}