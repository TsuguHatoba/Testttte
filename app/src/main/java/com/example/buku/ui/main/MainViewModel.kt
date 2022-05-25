package com.example.buku.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buku.data.BukuIT
import com.example.buku.data.BukuJapan
import com.example.buku.network.*
import kotlinx.coroutines.launch
import java.lang.Exception

enum class PoetryApiStatus { LOADING, ERROR, DONE }

class MainViewModel : ViewModel() {
    private val _status = MutableLiveData<PoetryApiStatus>()
    val status: LiveData<PoetryApiStatus> = _status

    private var _bukus = MutableLiveData<List<BukuIT>>()
    val bukus: LiveData<List<BukuIT>> = _bukus

    private var _buku = MutableLiveData<BukuIT>()
    val buku: LiveData<BukuIT> = _buku

    private var _japanBooks= MutableLiveData<List<BukuJapan>>()
    val japanBooks: LiveData<List<BukuJapan>> = _japanBooks

    private var _japanBook = MutableLiveData<BukuJapan>()
    val japanBook: LiveData<BukuJapan> = _japanBook

    fun getPoetryList() {
        viewModelScope.launch {
            _status.value = PoetryApiStatus.LOADING
            try {
                _japanBooks.value = PoetryApi.retrofitServiceApi.getData()

                _status.value = PoetryApiStatus.DONE
            } catch (e: Exception) {
                _japanBooks.value = listOf()
                _status.value = PoetryApiStatus.ERROR
            }
        }
    }

    fun onPoetryClicked(buku: BukuJapan) {
        _japanBook.value = buku
    }


}