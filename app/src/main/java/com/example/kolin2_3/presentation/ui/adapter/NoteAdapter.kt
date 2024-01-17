package com.example.kolin2_3.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kolin2_3.data.local.room.entities.Note
import com.example.kolin2_3.databinding.NoteItemBinding

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViwHolter>() {

    private var noteList = listOf<Note>()

    fun setNoteList(noteList: List<Note>) {
        this.noteList = noteList
    }
    class NoteViwHolter(private val biding: NoteItemBinding) :
        RecyclerView.ViewHolder(biding.root) {
        fun onBind(notesModel: Note) {
            biding.tvNote.text = notesModel.description
            biding.tvTitleNote.text = notesModel.title
            biding.tvDateTime.text = notesModel.date


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViwHolter {
        return NoteViwHolter(
            NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: NoteViwHolter, position: Int) {
        holder.onBind(noteList[position])
    }

}