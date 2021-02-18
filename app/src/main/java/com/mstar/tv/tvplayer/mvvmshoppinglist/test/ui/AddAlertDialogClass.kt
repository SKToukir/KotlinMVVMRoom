package com.mstar.tv.tvplayer.mvvmshoppinglist.test.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.mstar.tv.tvplayer.mvvmshoppinglist.R
import com.mstar.tv.tvplayer.mvvmshoppinglist.test.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddAlertDialogClass(context: Context,var addDialogListener: AddDialogListener): AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        txtAdd.setOnClickListener {
            if (etName.text.isEmpty() || etCount.text.isEmpty()){
                Toast.makeText(context,"Please give all information", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val name = etName.text.toString()
            val count = etCount.text.toString()

            val item = ShoppingItem(name, count.toInt())
            addDialogListener.onAddButtonClick(item)

            dismiss()
        }

        txtCancel.setOnClickListener {
            cancel()
        }
    }
}