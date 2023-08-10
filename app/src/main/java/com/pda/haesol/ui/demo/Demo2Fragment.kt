package com.pda.haesol.ui.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pda.haesol.databinding.FragmentDemo2Binding

class Demo2Fragment : Fragment() {

    private lateinit var viewModel: SharedViewModel

    private var _binding: FragmentDemo2Binding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val demo2ViewModel = ViewModelProvider(this).get(Demo2ViewModel::class.java)

        _binding = FragmentDemo2Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView = binding.button3
        demo2ViewModel.button.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        viewModel.data.observe(viewLifecycleOwner) { newData ->
            binding.button3.text = newData
        }
    }
}