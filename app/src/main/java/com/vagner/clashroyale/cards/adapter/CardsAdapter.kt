package com.vagner.clashroyale.cards.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vagner.clashroyale.cards.model.Item
import com.vagner.clashroyale.databinding.ItemCardBinding

class CardsAdapter(private val onClickListener: (Item) -> Unit) :
    RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {

    var cardList = listOf<Item>()
        set(value) {
            field = value
           notifyDataSetChanged()
        }


    override fun getItemCount(): Int = cardList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            ItemCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cardList[position], onClickListener)
    }

    inner class CardViewHolder(private val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(card: Item, onClickListener: (Item) -> Unit) {
            binding.txtNameCard.text = card.name
            binding.txtMaxlvl.text = card.maxLevel.toString()

            Glide.with(binding.imgCard).load(card.iconUrls.medium).into(binding.imgCard)

            itemView.setOnClickListener {
                onClickListener(card)
            }
        }
    }


}