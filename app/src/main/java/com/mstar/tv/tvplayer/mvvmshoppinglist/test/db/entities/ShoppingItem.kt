package com.mstar.tv.tvplayer.mvvmshoppinglist.test.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_shopping_list")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var itemName: String,
    @ColumnInfo(name = "item_count")
    var itemCount: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}