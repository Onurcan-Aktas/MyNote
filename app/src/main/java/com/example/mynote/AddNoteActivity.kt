package com.example.mynote

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mynote.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {
        private lateinit var binding: ActivityAddNoteBinding
        private lateinit var db: NotesDatabaseHelper

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding= ActivityAddNoteBinding.inflate(layoutInflater)
            setContentView(binding.root)

            db= NotesDatabaseHelper(this)


            binding.saveButton.setOnClickListener {
                val title=binding.titleEditText.text.toString()
                val content=binding.contentEditText.text.toString()
                val note= Note(0,title,content)
                db.insertNote(note)
                finish()
                Toast.makeText(this,"Note Added!", Toast.LENGTH_LONG).show()
            }
    }
}