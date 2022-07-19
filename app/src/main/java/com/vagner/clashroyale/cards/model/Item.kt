package com.vagner.clashroyale.cards.model

import com.vagner.clashroyale.cards.model.IconUrls

data class Item(
    val iconUrls: IconUrls,
    val id: Int,
    val maxLevel: Int,
    val name: String
)