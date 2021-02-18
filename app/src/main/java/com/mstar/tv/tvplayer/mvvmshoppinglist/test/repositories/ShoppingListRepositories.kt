package com.mstar.tv.tvplayer.mvvmshoppinglist.test.repositories

import com.mstar.tv.tvplayer.mvvmshoppinglist.test.db.ShoppingDatabase
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.db.entities.ShoppingItem

class ShoppingListRepositories(private val db: ShoppingDatabase) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().deleteItem(item)

    fun getAllItem() = db.getShoppingDao().getAllShoppingList()

}