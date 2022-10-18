package edu.temple.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SizeViewModel : ViewModel() {
    private val size = MutableLiveData<Float>()

    fun setSize(size: Float) { this.size.value = size }

    fun getSize() : LiveData<Float> { return size }
}