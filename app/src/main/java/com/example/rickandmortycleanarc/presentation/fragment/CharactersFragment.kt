package com.example.rickandmortycleanarc.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortycleanarc.R
import com.example.rickandmortycleanarc.databinding.FragmentCharacterBinding
import com.example.rickandmortycleanarc.presentation.activity.MainActivity
import com.example.rickandmortycleanarc.presentation.adapter.CharactersAdapter
import com.example.rickandmortycleanarc.presentation.viewModel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CharactersFragment : Fragment() {
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var binding: FragmentCharacterBinding

    @Inject
    lateinit var charactersAdapter: CharactersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)

        characterViewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
        characterViewModel.characters.observe(viewLifecycleOwner) {
            initRecyclerView()
            charactersAdapter.addCharacterList(it)
        }

        return binding.root
    }

    private fun initRecyclerView() {
        binding.characterRv.apply {
            adapter = charactersAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}