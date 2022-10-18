package edu.temple.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class TextFragment : Fragment() {

    private lateinit var sizeViewModel : SizeViewModel

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sizeViewModel = ViewModelProvider(requireActivity())[SizeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false).apply {
            textView = findViewById(R.id.textView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sizeViewModel.getSize().observe(requireActivity()) {
            changeTextSize(it)
        }
    }

    fun changeTextSize (size: Float) {

        // Only perform update if textView is previously initialized
        if (::textView.isInitialized)
            textView.textSize = size
    }

}