package com.tuannguyen.shazammusic.presentation.ui

import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuannguyen.shazammusic.R
import com.tuannguyen.shazammusic.data.util.Resource
import com.tuannguyen.shazammusic.databinding.FragmentSongsBinding
import com.tuannguyen.shazammusic.presentation.MainActivity
import com.tuannguyen.shazammusic.presentation.adapter.SongsAdapter
import com.tuannguyen.shazammusic.presentation.base.BaseFragment
import com.tuannguyen.shazammusic.presentation.viewmodel.SongsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SongsFragment: BaseFragment<FragmentSongsBinding, SongsViewModel>() {

    private val viewModel: SongsViewModel by viewModels()

    private lateinit var songAdapter: SongsAdapter

    override val layoutId: Int
        get() = R.layout.fragment_songs
    override val mViewModel: SongsViewModel
        get() = viewModel

    override fun initView() {
        super.initView()

        songAdapter = SongsAdapter()
        initRecyclerView()
        viewSongs()
        initSearchView()
    }

    private fun initRecyclerView() {
        binding.rcvRecommendedSongs.apply {
            adapter = songAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        songAdapter.setOnItemClickListener {
            val action = SongsFragmentDirections.actionSongsFragmentToSongInfoFragment(it)
            findNavController().navigate(action)
        }
    }

    private fun viewSongs() {
        viewModel.getSongs()
        viewModel.songs.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Success -> {
                    it.data?.let { data ->
                        songAdapter.differ.submitList(data.response!!.songs)
                    }
                    (activity as MainActivity).hideProgressBar()
                }
                is Resource.Loading -> {
                    (activity as MainActivity).showProgressbar()
                }
                is Resource.Error -> {
                    it.message?.let { message ->
                        Toast.makeText(activity, "An error occurred: $message", Toast.LENGTH_LONG).show()
                    }
                    (activity as MainActivity).hideProgressBar()
                }
            }
        })
    }

    private fun initSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    viewModel.searchSong(query)
                    viewSearchSongResult()
                }
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                MainScope().launch {
                    if (!query.isNullOrEmpty()) {
                        delay(2000)
                        viewModel.searchSong(query)
                        viewSearchSongResult()
                    }
                }
                return false
            }
        })

        binding.searchView.setOnCloseListener {
            (activity as MainActivity).hideKeyboard()
            initRecyclerView()
            viewSongs()
            false
        }
    }

    private fun viewSearchSongResult() {
        viewModel.searchedSongs.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Success -> {
                    songAdapter.differ.submitList(it.data!!.response!!.hits!!.map { searchResponse ->
                        searchResponse.result!!
                    })
                    (activity as MainActivity).hideProgressBar()
                }
                is Resource.Loading -> {
                    (activity as MainActivity).showProgressbar()
                }
                is Resource.Error -> {
                    it.message?.let { message ->
                        Toast.makeText(context, "An error occur: $message", Toast.LENGTH_LONG).show()
                    }
                    (activity as MainActivity).hideProgressBar()
                }
            }
        })
    }
}
