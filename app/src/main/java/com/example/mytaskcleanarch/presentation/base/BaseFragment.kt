package com.example.mytaskcleanarch.presentation.base

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.mytaskcleanarch.R

abstract class BaseFragment<VB : ViewBinding>(
    private val fragmentInflate: FragmentInflate<VB>
) : Fragment() {

    private var _binding: VB? = null

    // This property is only valid between onCreateView and onDestroyView.
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = fragmentInflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun showPopup(
        title: String = getString(R.string.general_error),
        message: String,
        doAfter: () -> Unit = {}
    ) {
        context?.let {
            AlertDialog.Builder(it)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(
                    R.string.ok
                ) { dialog, _ ->
                    doAfter.invoke()
                    dialog.dismiss()
                }
                .show()
        }
    }
}