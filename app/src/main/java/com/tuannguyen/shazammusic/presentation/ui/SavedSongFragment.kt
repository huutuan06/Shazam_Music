package com.tuannguyen.shazammusic.presentation.ui

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuannguyen.shazammusic.R
import com.tuannguyen.shazammusic.databinding.FragmentSavedSongBinding
import com.tuannguyen.shazammusic.presentation.adapter.SongsAdapter
import com.tuannguyen.shazammusic.presentation.base.BaseFragment
import com.tuannguyen.shazammusic.presentation.viewmodel.SavedSongViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedSongFragment : BaseFragment<FragmentSavedSongBinding, SavedSongViewModel>() {

    private val viewModel: SavedSongViewModel by viewModels()

    lateinit var songsAdapter: SongsAdapter

    override val layoutId: Int
        get() = R.layout.fragment_saved_song
    override val mViewModel: SavedSongViewModel
        get() = viewModel

    override fun initView() {
        super.initView()

        initRecyclerView()
        viewSavedSongs()
    }

    private fun initRecyclerView() {
        songsAdapter = SongsAdapter()
        binding.rcvRecommendedSongs.apply {
            adapter = songsAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun viewSavedSongs() {
        viewModel.getSavedSong().observe(viewLifecycleOwner, {
            songsAdapter.differ.submitList(it)
        })
    }
}
