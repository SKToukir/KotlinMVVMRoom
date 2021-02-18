package com.mstar.tv.tvplayer.mvvmshoppinglist.test

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.db.entities.ShoppingItem

@Dao
interface ShppingListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(shoppingItem: ShoppingItem)

    @Delete
    fun deleteItem(shoppingItem: ShoppingItem)

    @Query("SELECT * FROM tbl_shopping_list")
    fun getAllShoppingList(): LiveData<List<ShoppingItem>>

}