package com.example.lesson1month8.presentation.ui.fragments.list_of_note.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson1month8.databinding.NoteItemBinding
import com.example.lesson1month8.domain.model.Note

class ListOfNoteAdapter(private val removeClick: (Note, Int) -> Unit, private val editClick:(Note, Int)->Unit)  : RecyclerView.Adapter<ListOfNoteAdapter.ListOfNoteHolder>() {
    private var data = arrayListOf<Note>()
    fun addNotes(list: List<Note>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOfNoteHolder {
        return ListOfNoteHolder(
            NoteItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListOfNoteHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ListOfNoteHolder(private val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.tvTitle.text = note.title
            binding.tvDesc.text = note.desc
            itemView.setOnLongClickListener {
                removeClick(note,adapterPosition)
                false
            }
            itemView.setOnClickListener{
                editClick(note, adapterPosition)
            }
        }

    }

}