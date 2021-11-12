package com.tuannguyen.shazammusic.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.tuannguyen.shazammusic.BR

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment() {

    private var bindingVariable: Int = BR.viewModel

    @get:LayoutRes
    protected abstract val layoutId: Int
    protected abstract val mViewModel: V

    protected val binding: T
        get() = _binding!!
    private var _binding: T? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.setVariable(bindingVariable, mViewModel)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    open fun initView() {
    }
}
