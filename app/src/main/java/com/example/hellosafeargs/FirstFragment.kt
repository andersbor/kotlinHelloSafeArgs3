package com.example.hellosafeargs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hellosafeargs.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNext.setOnClickListener {
            val name = binding.edittextName.text.trim().toString()
            if (name.isEmpty()) {
                binding.edittextName.error = "No name"
                return@setOnClickListener
            }

            // Update both gradle files
            // https://developer.android.com/guide/navigation/use-graph/safe-args
            // Add argument element to nav_graph.xml (secondFragment)
            //val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(name)
            findNavController().navigate(action)
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.buttonNextDefaultValue.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragmentWithDefaultValue()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}