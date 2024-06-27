package com.vanshika.spinnerapp

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import com.vanshika.spinnerapp.databinding.CustomDialogBinding
import com.vanshika.spinnerapp.databinding.FragmentArrayAdapterBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ArrayAdapterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArrayAdapterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var binding: FragmentArrayAdapterBinding? = null
    lateinit var arrayAdapter: ArrayAdapter<String>
    var array = arrayListOf("Enter")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArrayAdapterBinding.inflate(inflater)
        return binding?.root
//        return inflater.inflate(R.layout.fragment_array_adapter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrayAdapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_list_item_1, array
        )
        binding?.lvArrayAdapter?.adapter = arrayAdapter
        binding?.arrayFab?.setOnClickListener {
            val dialogBinding = CustomDialogBinding.inflate(layoutInflater)
            val dialog = Dialog(requireContext()).apply {
                setContentView(dialogBinding.root)
                show()
            }
            dialogBinding.btnAdd.setOnClickListener {
                if (dialogBinding.etEnterCity.text?.toString().isNullOrEmpty()) {
                    dialogBinding.etEnterCity.error = resources.getString(R.string.enter_your_city)
                } else {
                    array.add(dialogBinding.etEnterCity.text.toString())
                    dialog.dismiss()
                }
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ArrayAdapterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ArrayAdapterFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}
