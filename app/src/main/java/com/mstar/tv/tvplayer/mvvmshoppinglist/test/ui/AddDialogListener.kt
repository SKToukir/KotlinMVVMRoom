package com.mstar.tv.tvplayer.mvvmshoppinglist.test.ui

import com.mstar.tv.tvplayer.mvvmshoppinglist.test.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClick(item: ShoppingItem)
}