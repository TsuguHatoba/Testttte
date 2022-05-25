package com.example.buku.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buku.R
import com.example.buku.databinding.FragmentPoetryListBinding
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment(){
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPoetryListBinding.inflate(inflater)
        viewModel.getPoetryList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = MainFragmentAdapter(PoetryListener { poetry ->
            viewModel.onPoetryClicked(poetry)
            findNavController()
                .navigate(R.id.action_poetryListFragment_to_poetryDetailFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "List puisi"
        // menambahkan dekorasi garis bawah
        binding.recyclerView.addItemDecoration(MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))


        return binding.root
    }
}