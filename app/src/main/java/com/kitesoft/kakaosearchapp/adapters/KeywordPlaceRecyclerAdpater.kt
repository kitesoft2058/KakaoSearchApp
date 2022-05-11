package com.kitesoft.kakaosearchapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kitesoft.kakaosearchapp.R
import com.kitesoft.kakaosearchapp.databinding.RecyclerPlaceItemBinding
import com.kitesoft.kakaosearchapp.model.PlaceItem

class KeywordPlaceRecyclerAdapter constructor(val context:Context,var items:MutableList<PlaceItem>): RecyclerView.Adapter<KeywordPlaceRecyclerAdapter.VH>(){

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding:RecyclerPlaceItemBinding= RecyclerPlaceItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemView= LayoutInflater.from(context).inflate(R.layout.recycler_place_item, parent, false)
        return VH(itemView)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.tvPlaceName.text= items[position].place_name
        if(items[position].road_address_name.equals("")) holder.binding.tvAddress.text= items[position].address_name
        else holder.binding.tvAddress.text= items[position].road_address_name
        holder.binding.tvDistance.text= items[position].distance+"m"
    }

    override fun getItemCount(): Int = items.size

}