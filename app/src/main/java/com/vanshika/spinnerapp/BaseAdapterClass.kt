package com.vanshika.spinnerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class BaseAdapterClass(var array : ArrayList<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return array.size
    }

    override fun getItem(p0: Int): Any {
        return array[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 1L
    }

    override fun getView(p0: Int, p1: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_base_adapter, parent,
                false)
        var tvName = view.findViewById<TextView>(R.id.tvName)
        var tvRollNo = view.findViewById<TextView>(R.id.tvRollNo)
        tvName.setText(array[p0])
        return view
    }
}
