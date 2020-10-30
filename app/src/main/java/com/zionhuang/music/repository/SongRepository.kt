package com.zionhuang.music.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.zionhuang.music.db.MusicDatabase
import com.zionhuang.music.db.SongDao
import com.zionhuang.music.db.SongEntity
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.Flow

class SongRepository(context: Context) {
    companion object {
        private const val TAG = "SongRepository"
    }

    private val songDao: SongDao = MusicDatabase.getInstance(context).songDao

    fun getAllSongsAsLiveData(): LiveData<List<SongEntity>> = songDao.getAllSongsAsLiveData()

    fun getAllSongsAsFlow(): Flow<List<SongEntity>> = songDao.getAllSongsAsFlow()

    fun getSongById(id: String): SongEntity? = songDao.getSongById(id)

    fun insert(song: SongEntity) = songDao.insert(song)

    fun deleteAll() = songDao.deleteAll()
            .subscribeOn(Schedulers.io())
            .subscribe()
}