package com.mstar.tv.tvplayer.mvvmshoppinglist.test.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.repositories.ShoppingListRepositories

@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(private val repositories: ShoppingListRepositories): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModelTest(repositories) as T
    }

}