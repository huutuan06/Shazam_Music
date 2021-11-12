package com.tuannguyen.shazammusic.presentation.ui

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuannguyen.shazammusic.R
import com.tuannguyen.shazammusic.databinding.FragmentSongsBinding
import com.tuannguyen.shazammusic.presentation.adapter.SongsAdapter
import com.tuannguyen.shazammusic.presentation.base.BaseFragment
import com.tuannguyen.shazammusic.presentation.viewmodel.SongsViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response

@AndroidEntryPoint
class SongsFragment: BaseFragment<FragmentSongsBinding, SongsViewModel>() {

    private val viewModel: SongsViewModel by viewModels()

    private lateinit var songAdapter: SongsAdapter

    private var key = "484129036"
    private var locale = "en-US"

    override val layoutId: Int
        get() = R.layout.fragment_songs
    override val mViewModel: SongsViewModel
        get() = viewModel

    override fun initView() {
        super.initView()

        initRecyclerView()
        viewSongs()
    }

    private fun initRecyclerView() {
        songAdapter = SongsAdapter()
        binding.rcvRecommendedSongs.apply {
            adapter = songAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun viewSongs() {
        viewModel.getRecommendedSongs(key, locale)
        viewModel.recommendedSongs.observe(viewLifecycleOwner, {
            if (it.isSuccessful) {
                songAdapter.differ.submitList(it.body()!!.tracks)
            } else {
                Toast.makeText(context, "Error!", Toast.LENGTH_LONG).show()
            }
        })
    }
}
