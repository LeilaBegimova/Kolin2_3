package com.example.kolin2_3.presentation.ui.fragments.add

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kolin2_3.R
import com.example.kolin2_3.data.local.room.entities.Note
import com.example.kolin2_3.data.models.App
import com.example.kolin2_3.databinding.FragmentAddNoteBinding
import java.sql.Time
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date

class AddNoteFragment : Fragment() {
    private var _biding: FragmentAddNoteBinding? = null
    private val binding get() = _biding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _biding = FragmentAddNoteBinding.inflate(inflater, container, false)

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()

    }

    override fun onDestroy() {
        super.onDestroy()
        _biding = null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupListeners() {
        binding.buttonOne.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
            val title = binding.textEd.text.trim().toString()
            val destination = binding.textEdTwo.text.trim().toString()
            val date = LocalDate.now()
            (App.db.noteDao().addNote(
                Note(
                    title = title,
                    description = destination,
                    date = "${date.dayOfMonth} ${date.month.name} \n  ${Date().hours}:${Date().minutes}"
                )
            ))
        }
    }
}
