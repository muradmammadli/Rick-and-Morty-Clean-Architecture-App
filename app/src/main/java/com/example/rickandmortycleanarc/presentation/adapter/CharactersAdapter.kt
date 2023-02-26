package com.example.rickandmortycleanarc.presentation.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortycleanarc.R
import com.example.rickandmortycleanarc.data.model.CharacterList
import com.example.rickandmortycleanarc.data.model.Result
import com.example.rickandmortycleanarc.databinding.CharacterRowBinding

class CharactersAdapter(
    val callback:AdapterCallbacks
) :
    RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {
    private var characterList: List<Result>? = null

    fun addCharacterList(characterList: List<Result>){
        this.characterList = characterList
        notifyDataSetChanged()
    }

    class CharacterViewHolder(val binding: CharacterRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            CharacterRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characterList?.get(position)
        if (character != null){
            holder.binding.characterName.text = character.name
            Glide.with(holder.itemView.context).load(character.image).into(holder.binding.characterImg)
            holder.itemView.setOnClickListener {
                character.id?.let { it1 -> callback.handleCharacterId(it1) }
            }
        }

    }

    override fun getItemCount(): Int {
        return characterList?.size ?: 0
    }

    interface AdapterCallbacks {
        fun handleCharacterId(characterId:Int)
    }

}