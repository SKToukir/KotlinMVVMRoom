package com.mstar.tv.tvplayer.mvvmshoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mstar.tv.tvplayer.mvvmshoppinglist.R
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.db.entities.ShoppingItem
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.ui.ShoppingViewModelTest
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingListAdapter(val viewModel: ShoppingViewModelTest, var list: List<ShoppingItem>) :
    RecyclerView.Adapter<ShoppingListAdapter.ItemViewModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewModel {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)

        return ItemViewModel(view)
    }

    override fun onBindViewHolder(holder: ItemViewModel, position: Int) {
        var shoppingItem = list[position]

        holder.itemView.textView.text = shoppingItem.itemName
        holder.itemView.textView2.text = "${shoppingItem.itemCount}"

        holder.itemView.setOnClickListener{
            viewModel.delete(shoppingItem)
        }

        holder.itemView.imageView2.setOnClickListener {
            shoppingItem.itemCount++
            viewModel.upsert(shoppingItem)
        }

        holder.itemView.imageView3.setOnClickListener {
            if (shoppingItem.itemCount > 0){
                shoppingItem.itemCount--
                viewModel.delete(shoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ItemViewModel(itemView: View) : RecyclerView.ViewHolder(itemView)

    companion object {
        private const val TAG = "ShoppingListAdapter"
    }
}