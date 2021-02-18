package com.mstar.tv.tvplayer.mvvmshoppinglist.test.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.db.entities.ShoppingItem
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.ShppingListDao

@Database(entities = [ShoppingItem::class], version = 2)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingDao(): ShppingListDao

    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
            instance
                ?: createDatabase(
                    context
                )
                    .also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDatabase::class.java, "ShoppingListDB.db"
            ).build()

    }

}