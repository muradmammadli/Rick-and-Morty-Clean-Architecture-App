package com.example.rickandmortycleanarc.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.rickandmortycleanarc.R
import com.example.rickandmortycleanarc.databinding.FragmentInfoBinding
import com.example.rickandmortycleanarc.presentation.viewModel.InfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment : Fragment() {
    private lateinit var infoViewModel: InfoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentInfoBinding.inflate(inflater, container, false)
        val characterId = requireArguments().getInt("characterId")

        infoViewModel = ViewModelProvider(this)[InfoViewModel::class.java]
        infoViewModel.getCharacterInfo(characterId)
        infoViewModel.characterInfo.observe(viewLifecycleOwner) {
            Glide.with(this).load(it.image).into(binding.characterImg)
            binding.characterName.text = it.name
            binding.characterSpecies.text = it.species
            binding.characterGender.text = it.gender
            binding.characterOriginName.text = it.origin?.name ?: "null"
        }
        return binding.root
    }
}