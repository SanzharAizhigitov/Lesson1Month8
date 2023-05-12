package com.example.lesson1month8.presentation.ui.fragments.create_edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.lesson1month8.databinding.FragmentCreateEditBinding
import com.example.lesson1month8.domain.model.Note
import com.example.lesson1month8.presentation.base.BaseFragment
import com.example.lesson1month8.presentation.ui.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.Random

@AndroidEntryPoint
class CreateEditFragment : BaseFragment() {

    private lateinit var binding: FragmentCreateEditBinding
    private val viewModel by viewModels<CreateEditViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        binding.createEditBtn.setOnClickListener {
            val random = Random().nextInt(2)
            if (random == 0) {
                createNote(
                    Note(
                        title = binding.titleEt.text.toString(),
                        desc = binding.descEt.text.toString()
                    )
                )
            } else {
                //editNote()
                //Нет данных на что заменять, крч это надо весь код ворошить
            }
        }
    }

    private fun createNote(note: Note) {
        viewModel.createNote(note)
        viewModel.createNoteState.collectState(state = {state->
           // binding.progressBar.isVisible = state is UIState.Loading
        }, onSuccess = { data ->
            //adapter.addList(data)
        })
    }

    private fun editNote(note: Note) {
        viewModel.editNote(note)
        viewModel.editNoteState.collectState(state = {state->
           // binding.progressBar.isVisible = state is UIState.Loading
        }, onSuccess = { data ->
            //adapter.addList(data)
        })
    }

}