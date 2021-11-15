package com.tuannguyen.shazammusic.presentation.ui

import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.tuannguyen.shazammusic.R
import com.tuannguyen.shazammusic.databinding.FragmentSongInfoBinding
import com.tuannguyen.shazammusic.presentation.base.BaseFragment
import com.tuannguyen.shazammusic.presentation.viewmodel.SongInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SongInfoFragment: BaseFragment<FragmentSongInfoBinding, SongInfoViewModel>() {

    private val viewModel: SongInfoViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.fragment_song_info
    override val mViewModel: SongInfoViewModel
        get() = viewModel

    override fun initView() {
        super.initView()
        val args: SongInfoFragmentArgs by navArgs()
        val song = args.selectedSong

        binding.webView.apply {
            webViewClient = WebViewClient()
            clearCache(true)
            clearHistory()
            settings.javaScriptCanOpenWindowsAutomatically = true
            song.let {
                if (!it.url.isNullOrEmpty()) {
                    loadUrl(it.url)
                }
            }
        }

        binding.floatButton.setOnClickListener {
            viewModel.saveSongToDB(song)
            Snackbar.make(requireView(),"Saved Successfully!", Snackbar.LENGTH_LONG).show()
        }
    }
}
