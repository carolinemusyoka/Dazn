package com.carolmusyoka.dazn.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carolmusyoka.dazn.domain.model.NetworkResult
import com.carolmusyoka.dazn.domain.model.events.EventUiState
import com.carolmusyoka.dazn.domain.usecases.EventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val eventsUseCase: EventsUseCase
): ViewModel() {

    private val _eventsResponse: MutableStateFlow<EventUiState> = MutableStateFlow(EventUiState(true, null, false))
    val events get() = _eventsResponse

    fun getEvents(){
        viewModelScope.launch {
            _eventsResponse.emit(EventUiState(true, null, false))
            when (val response = eventsUseCase.invoke()){
                is NetworkResult.Success -> {
                    _eventsResponse.emit(EventUiState(false, response.data, false))
                }
                is NetworkResult.Failure -> {
                    _eventsResponse.emit(EventUiState(false, null, true))
                }
            }
        }
    }
}
