package com.example.m7hw1.data.repository

import com.example.m7hw1.data.base.BaseRepository
import com.example.m7hw1.data.local.NoteDao
import com.example.m7hw1.data.mappers.toNote
import com.example.m7hw1.data.mappers.toNoteEntity
import com.example.m7hw1.domain.model.Note
import com.example.m7hw1.domain.repository.NoteRepository
import com.example.m7hw1.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao) : BaseRepository() , NoteRepository {

    override fun createNote(note: Note) = doRequest {
        noteDao.createNote(note.toNoteEntity())
    }

    override fun editNote(note: Note) = doRequest {
        noteDao.editNote(note.toNoteEntity())
    }

    override fun deleteNote(note: Note) = doRequest {
        noteDao.deleteNote(note.toNoteEntity())
    }

    override fun getNote() = doRequest {
        noteDao.getNote().map { it.toNote() }
    }


}