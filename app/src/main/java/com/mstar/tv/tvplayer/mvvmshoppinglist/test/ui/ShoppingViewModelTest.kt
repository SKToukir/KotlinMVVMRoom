package com.mstar.tv.tvplayer.mvvmshoppinglist.test.ui

import androidx.lifecycle.ViewModel
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.db.entities.ShoppingItem
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.repositories.ShoppingListRepositories
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingViewModelTest(private val repositories: ShoppingListRepositories): ViewModel() {

   fun upsert(item: ShoppingItem) = GlobalScope.launch {
       repositories.upsert(item)
   }

    fun delete(item: ShoppingItem) = GlobalScope.launch {
        repositories.delete(item)
    }

    fun getAllItem() = repositories.getAllItem()

}