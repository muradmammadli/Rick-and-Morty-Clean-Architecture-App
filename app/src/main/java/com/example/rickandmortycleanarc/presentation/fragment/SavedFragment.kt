package com.example.rickandmortycleanarc.presentation.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortycleanarc.R
import com.example.rickandmortycleanarc.data.model.Result
import com.example.rickandmortycleanarc.databinding.FragmentCharacterBinding
import com.example.rickandmortycleanarc.databinding.FragmentSavedBinding
import com.example.rickandmortycleanarc.presentation.adapter.CharactersAdapter
import com.example.rickandmortycleanarc.presentation.viewModel.CharacterViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty

@AndroidEntryPoint
class SavedFragment : Fragment(), CharactersAdapter.AdapterCallbacks {
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var binding: FragmentSavedBinding
    lateinit var charactersAdapter: CharactersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavedBinding.inflate(inflater, container, false)
        setMenu()
        getViewModelData()
        return binding.root
    }

    private fun initRecyclerView() {
        charactersAdapter = CharactersAdapter(this)
        binding.characterRv.apply {
            adapter = charactersAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun getViewModelData() {
        characterViewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
        characterViewModel.getSavedCharacters().observe(viewLifecycleOwner) {
            initRecyclerView()
            if (it != null) {
                charactersAdapter.addCharacterList(it)
            }
        }
    }

    private fun setMenu() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)
                val menuItem = menu.findItem(R.id.action_search)
                val searchView: SearchView = menuItem.actionView as SearchView
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        characterViewModel.getSearchedCharacters(query)
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        characterViewModel.getSearchedCharacters(newText)
                        return true
                    }
                })
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_search -> {
                        true
                    }
                    else -> false
                }
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun setAlertDialog(result: Result) {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Delete")
        builder.setMessage("Do you want to delete?")
        builder.setPositiveButton("Yes") { dialog, which ->
            characterViewModel.deletCharacterUseCase(result)
            Toasty.error(requireActivity(),"Deleted successfully",Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { dialog, which -> }
        builder.show()
    }

    override fun handleCharacterId(characterId: Int) {
        findNavController().navigate(R.id.action_mainFragment_to_infoFragment, Bundle().apply {
            putInt("characterId", characterId)
        })
    }

    override fun onClickSaveButton(result: Result) {
        characterViewModel.saveCharacters(result)
        Toasty.success(requireActivity(),"Saved successfully",Toast.LENGTH_SHORT).show()
    }

    override fun onClickDeleteButton(result: Result) {
        setAlertDialog(result)
    }

    override fun visibilitySaveButton(saveButton: Button) {
        saveButton.visibility = View.GONE
    }

    override fun visibilityDeleteButton(deleteButton: Button) {
        deleteButton.visibility = View.VISIBLE
    }
}