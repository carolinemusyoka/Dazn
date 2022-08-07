package com.carolmusyoka.dazn.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carolmusyoka.dazn.domain.model.NetworkResult
import com.carolmusyoka.dazn.domain.model.scheduled.ScheduledUiState
import com.carolmusyoka.dazn.domain.usecases.ScheduledUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduledViewModel @Inject constructor(
     private val scheduledUseCase: ScheduledUseCase
) : ViewModel() {

    private val _scheduledEventsResponse: MutableStateFlow<ScheduledUiState> = MutableStateFlow(
        ScheduledUiState(true, null, false)
    )
    val scheduled get() = _scheduledEventsResponse

    fun getScheduledEvents() {
        viewModelScope.launch {
            _scheduledEventsResponse.emit(ScheduledUiState(true, null, false))
            when (val response = scheduledUseCase.invoke()){
                is NetworkResult.Success -> {
                    _scheduledEventsResponse.emit(ScheduledUiState(false, response.data, false))
                }
                is NetworkResult.Failure -> {
                    _scheduledEventsResponse.emit(ScheduledUiState(false, null, true))
                }
            }
        }
    }
}
