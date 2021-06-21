package com.example.mytaskcleanarch.presentation.albumlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mytaskcleanarch.R
import com.example.mytaskcleanarch.databinding.FragmentAlbumListBinding
import com.example.mytaskcleanarch.presentation.albumlist.adapters.AlbumListAdapter
import com.example.mytaskcleanarch.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumListFragment : BaseFragment<FragmentAlbumListBinding>(FragmentAlbumListBinding::inflate) {

    private val albumViewModel by viewModel<AlbumListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = super.onCreateView(inflater, container, savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewModel = albumViewModel

        albumViewModel.getAlbums()
        observeViewModel()

        val albumAdapter = AlbumListAdapter()
        binding.adapter = albumAdapter

        return root
    }

    private fun observeViewModel(){
        albumViewModel.isLoading.observe(viewLifecycleOwner, {
            if(it) {
                binding.progressBarAlbums.visibility = View.VISIBLE
            } else {
                binding.progressBarAlbums.visibility = View.GONE
            }
        })

        albumViewModel.error.observe(viewLifecycleOwner, {
            showPopup(message = it)
        })

        albumViewModel.listOfAlbums.observe(viewLifecycleOwner, {
            (binding.adapter as AlbumListAdapter).submitList(it)
        })
    }

}