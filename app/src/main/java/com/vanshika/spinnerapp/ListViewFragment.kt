package com.vanshika.spinnerapp

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.clearFragmentResultListener
import com.vanshika.spinnerapp.databinding.CustomDialogBinding
import com.vanshika.spinnerapp.databinding.CustomdialogfordatainputBinding
import com.vanshika.spinnerapp.databinding.FragmentListViewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListViewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var binding: FragmentListViewBinding? = null
    var studentArray = arrayListOf<DataAdapter>()
    var adapter = BaseAdapterWithDataClass(studentArray)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        studentArray.add(DataAdapter(1, "Test", "C"))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListViewBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.lvBaseAdapterWithData?.adapter = adapter
        binding?.dataFab?.setOnClickListener {
            val dialogBinding = CustomdialogfordatainputBinding.inflate(layoutInflater)
            val dialog = Dialog(requireContext()).apply {
                setContentView(dialogBinding.root)
                getWindow()?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                show()
            }
            dialogBinding.btnSubmit.setOnClickListener {
                if (dialogBinding.etEnterRollNo.text.toString().trim().isEmpty()) {
                    dialogBinding.etEnterRollNo.error =
                        resources.getString(R.string.enter_your_roll_no)
                } else if (dialogBinding.etEnterName.text.toString().trim().isEmpty()) {
                    dialogBinding.etEnterName.error = resources.getString(R.string.enter_your_name)
                } else if (dialogBinding.etEnterCourse.text.toString().trim().isEmpty()) {
                    dialogBinding.etEnterCourse.error =
                        resources.getString(R.string.enter_your_course)
                } else {
                    studentArray.add(
                        DataAdapter(
                            dialogBinding.etEnterRollNo.text.toString().toInt(),
                            dialogBinding.etEnterName.text.toString(),
                            dialogBinding.etEnterCourse.text.toString()
                        )
                    )
                    dialog.dismiss()
                }
            }
        }
        binding?.lvBaseAdapterWithData?.setOnItemClickListener { adapterView, view, i, l ->

            val dialogBinding = CustomdialogfordatainputBinding.inflate(layoutInflater)
            val dialog = Dialog(requireContext()).apply {
                setContentView(dialogBinding.root)
                getWindow()?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                show()
            }
            dialogBinding.btnSubmit.setOnClickListener {
                if (dialogBinding.etEnterRollNo.text.toString().trim().isEmpty()) {
                    dialogBinding.etEnterRollNo.error =
                        resources.getString(R.string.enter_your_roll_no)
                } else if (dialogBinding.etEnterName.text.toString().trim().isEmpty()) {
                    dialogBinding.etEnterName.error =
                        resources.getString(R.string.enter_your_name)
                } else if (dialogBinding.etEnterCourse.text.toString().trim().isEmpty()) {
                    dialogBinding.etEnterCourse.error =
                        resources.getString(R.string.enter_your_course)
                } else {
                    studentArray.set(
                        i,
                        DataAdapter(
                            dialogBinding.etEnterRollNo.text.toString().toInt(),
                            dialogBinding.etEnterName.text.toString(),
                            dialogBinding.etEnterCourse.text.toString()
                        )
                    )

                    dialog.dismiss()
                }
            }
        }
        binding?.lvBaseAdapterWithData?.setOnItemLongClickListener { adapterView, view, i, l ->

            val dialogBinding = CustomdialogfordatainputBinding.inflate(layoutInflater)
            val dialog = Dialog(requireContext()).apply {
                setContentView(dialogBinding.root)
                show()
                getWindow()?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
            dialogBinding.btnSubmit.setOnClickListener {
                if (dialogBinding.etEnterRollNo.text.toString().trim().isEmpty()) {
                    dialogBinding.etEnterRollNo.error = resources.getString(R.string.enter_your_roll_no)
                } else if (dialogBinding.etEnterName.text.toString().trim().isEmpty()) {
                    dialogBinding.etEnterName.error = resources.getString(R.string.enter_your_name)
                } else if (dialogBinding.etEnterCourse.text.toString().trim().isEmpty()) {
                    dialogBinding.etEnterCourse.error = resources.getString(R.string.enter_your_course)
                } else {
                    studentArray.remove(
                        DataAdapter(
                            dialogBinding.etEnterRollNo.text.toString().toInt(),
                            dialogBinding.etEnterName.text.toString(),
                            dialogBinding.etEnterCourse.text.toString()
                        )
                    )
                }
            }
            return@setOnItemLongClickListener true
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ListViewFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}

