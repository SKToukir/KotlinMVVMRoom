package com.mstar.tv.tvplayer.mvvmshoppinglist.real.db.repositories

import com.mstar.tv.tvplayer.mvvmshoppinglist.real.db.data.ShoppingDatabase
import com.mstar.tv.tvplayer.mvvmshoppinglist.real.db.entities.ShoppingItem

class ShoppingRepositories(private val db: ShoppingDatabase) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItem() = db.getShoppingDao().getAllShoppingItem()

}