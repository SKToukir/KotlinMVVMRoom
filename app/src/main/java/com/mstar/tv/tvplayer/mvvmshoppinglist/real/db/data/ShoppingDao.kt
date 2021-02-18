package com.mstar.tv.tvplayer.mvvmshoppinglist.real.db.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mstar.tv.tvplayer.mvvmshoppinglist.real.db.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(item: ShoppingItem)

    @Delete
    fun delete(item: ShoppingItem)

    @Query("SELECT * FROM tbl_shopping_list")
    fun getAllShoppingItem(): LiveData<List<ShoppingItem>>
}