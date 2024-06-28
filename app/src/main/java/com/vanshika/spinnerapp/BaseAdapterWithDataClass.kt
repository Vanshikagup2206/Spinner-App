package com.vanshika.spinnerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.coroutines.NonDisposableHandle.parent

class BaseAdapterWithDataClass(var studentList: ArrayList<DataAdapter>) : BaseAdapter() {
    override fun getCount(): Int {
        return studentList.size
    }

    override fun getItem(p0: Int): Any {
        return studentList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return studentList[p0].rollNo?.toLong()?:0L
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(p2?.context).inflate(R.layout.item_data_adapter,p2,false)
        val tvStudentName : TextView = view.findViewById(R.id.tvStudentName)
        val tvStudentRollNo : TextView = view.findViewById(R.id.tvStudentRollNo)
        val tvStudentCourse : TextView = view.findViewById(R.id.tvStudentCourse)
        tvStudentRollNo.setText(studentList[p0].rollNo.toString())
        tvStudentName.setText(studentList[p0].name.toString())
        tvStudentCourse.setText(studentList[p0].course.toString())
        return view
    }
}