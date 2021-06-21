package com.example.mytaskcleanarch.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>(
    private val fragmentInflate: ActivityInflate<VB>
): AppCompatActivity() {

    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = fragmentInflate.invoke(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}