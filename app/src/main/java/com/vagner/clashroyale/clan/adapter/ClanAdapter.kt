package com.vagner.clashroyale.clan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vagner.clashroyale.clan.model.ClanModelItem
import com.vagner.clashroyale.databinding.ItemClanBinding

class ClanAdapter(private val onClickListener: (ClanModelItem) -> Unit) :
    RecyclerView.Adapter<ClanAdapter.ClanViewHolder>() {

    var clanList = listOf<ClanModelItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClanViewHolder {
        return ClanViewHolder(
            ItemClanBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = clanList.size

    override fun onBindViewHolder(holder: ClanViewHolder, position: Int) {
        holder.bind(clanList[position], onClickListener)
    }

    inner class ClanViewHolder(private val binding: ItemClanBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clan: ClanModelItem, onClickListener: (ClanModelItem) -> Unit) {
            binding.textNameClan.text = clan.name
            binding.textAmountPlayers.text = clan.members.toString()
            binding.textTotalTrophies.text = clan.requiredTrophies.toString()

            itemView.setOnClickListener {
                onClickListener(clan)
            }
        }

    }
}