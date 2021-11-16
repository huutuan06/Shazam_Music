package com.tuannguyen.shazammusic.presentation.ui

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.tuannguyen.shazammusic.R
import com.tuannguyen.shazammusic.databinding.FragmentSavedSongBinding
import com.tuannguyen.shazammusic.presentation.adapter.SongsAdapter
import com.tuannguyen.shazammusic.presentation.base.BaseFragment
import com.tuannguyen.shazammusic.presentation.viewmodel.SavedSongViewModel
import com.tuannguyen.shazammusic.presentation.viewmodel.SongInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedSongFragment : BaseFragment<FragmentSavedSongBinding, SavedSongViewModel>() {

    private val viewModel: SavedSongViewModel by viewModels()
    private val songInfoViewModel: SongInfoViewModel by viewModels()

    lateinit var songsAdapter: SongsAdapter

    override val layoutId: Int
        get() = R.layout.fragment_saved_song
    override val mViewModel: SavedSongViewModel
        get() = viewModel

    override fun initView() {
        super.initView()

        initRecyclerView()
        viewSavedSongs()
        setupSwipeRecyclerView()
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

    private fun setupSwipeRecyclerView() {
        val itemTouchHelperCallback = object: ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val song = songsAdapter.differ.currentList[position]
                viewModel.deleteSong(song)
                Snackbar.make(view!!, "Deleted Successfully", Snackbar.LENGTH_LONG)
                    .apply {
                        setAction("Undo") {
                            songInfoViewModel.saveSongToDB(song)
                        }
                        show()
                    }
            }

        }
        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.rcvRecommendedSongs)
        }
    }
}
