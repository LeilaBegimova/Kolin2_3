package com.example.kolin2_3.presentation.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kolin2_3.R
import com.example.kolin2_3.data.local.room.entities.Note
import com.example.kolin2_3.data.models.App
import com.example.kolin2_3.databinding.FragmentHomeBinding
import com.example.kolin2_3.presentation.ui.adapter.NoteAdapter

class HomeFragment : Fragment() {
    private lateinit var biding: FragmentHomeBinding
    private val noteAdapter = NoteAdapter(::onLongItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        biding = FragmentHomeBinding.inflate(layoutInflater)
        return biding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
    }

    private fun initialize() {
      val noteList= App.db.noteDao().getAllNotes()
        biding.rvNotes.adapter = noteAdapter
    }

    private fun setupListeners() {
        biding.btnAddNote.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
        }
    }
    private fun onLongItemClick(position:Int, note:Note){
        App.db.noteDao().deleteNote(note)
        noteAdapter.setNoteList(position)

    }
}