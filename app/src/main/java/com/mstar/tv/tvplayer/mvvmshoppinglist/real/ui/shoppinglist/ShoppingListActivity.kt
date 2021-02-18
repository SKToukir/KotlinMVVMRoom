package com.mstar.tv.tvplayer.mvvmshoppinglist.real.db.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mstar.tv.tvplayer.mvvmshoppinglist.R
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.db.ShoppingDatabase
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.db.entities.ShoppingItem
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.other.ShoppingListAdapter
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.repositories.ShoppingListRepositories
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.ui.AddAlertDialogClass
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.ui.AddDialogListener
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.ui.ShoppingViewModelTest
import kotlinx.android.synthetic.main.activity_main.*

class ShoppingListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = ShoppingDatabase(applicationContext)
        val repositories = ShoppingListRepositories(db)
        val factory = ShoppingViewModelFactory(repositories)
        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModelTest::class.java)

        val adapter = ShoppingListAdapter(listOf(),viewModel)

        rlShoppingList.layoutManager = LinearLayoutManager(this)
        rlShoppingList.adapter = adapter

        viewModel.getAllItem().observe(this, Observer {
            adapter.list = it
            adapter.notifyDataSetChanged()
        })

        btnFloat.setOnClickListener { 
            AddAlertDialogClass(this, object : AddDialogListener{
                override fun onAddButtonClick(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}