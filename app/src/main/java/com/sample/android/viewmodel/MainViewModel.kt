package com.sample.android.viewmodel

import androidx.lifecycle.ViewModel
import com.sample.android.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Description:逻辑控制
 * Remark:
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val mRepository: MainRepository
) : ViewModel() {

}