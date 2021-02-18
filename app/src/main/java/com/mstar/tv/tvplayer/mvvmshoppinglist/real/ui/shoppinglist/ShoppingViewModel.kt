package com.mstar.tv.tvplayer.mvvmshoppinglist.real.db.shoppinglist

import androidx.lifecycle.ViewModel
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.db.entities.ShoppingItem
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.repositories.ShoppingListRepositories
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repositories: ShoppingListRepositories): ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch { repositories.upsert(item) }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch { repositories.delete(item) }

    fun getAllShoppingItem() = repositories.getAllItem()

}