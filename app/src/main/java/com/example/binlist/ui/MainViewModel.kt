package com.example.binlist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.helper.Resource
import com.example.core.models.BinInfo
import com.example.core.usecases.GetBinlistUseCase
import com.example.core.usecases.RetrieveBinInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getBinlistUseCase: GetBinlistUseCase,
    private val retrieveBinInfoUseCase: RetrieveBinInfoUseCase
) : ViewModel() {

    val binList = getBinlistUseCase
        .invoke()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    private val _binInfoBoxState = MutableStateFlow(BinInfoBoxState())
    val binInfoBoxState = _binInfoBoxState.asStateFlow()

    private val _status = MutableLiveData<Resource.NetworkApiStatus>()
    val status: LiveData<Resource.NetworkApiStatus> = _status

    fun retrieveBinInfo(query: String) {
        viewModelScope.launch {
            _status.value = Resource.NetworkApiStatus.LOADING
            try {
                retrieveBinInfoUseCase.invoke(query = query)
                _status.value = Resource.NetworkApiStatus.SUCCESS
            } catch (e: Exception) {
                _status.value = Resource.NetworkApiStatus.ERROR
            }
        }
    }
}

data class BinInfoBoxState(
    override val id: Int = 0,
    override val numberLength: String = "16",
    override val numberLuhn: String = "Yes/No",
    override val scheme: String = "VISA",
    override val type: String = "Debit",
    override val brand: String = "Visa/Dancort",
    override val prepaid: String = "No",
    override val countryNumeric: String = "208",
    override val countryAlpha2: String = "DK",
    override val countryName: String = "Denmark",
    override val countryEmoji: String = "DK",
    override val countryCurrency: String = "DKK",
    override val countryLatitude: String = "56",
    override val countryLongitude: String = "10",
    override val bankName: String = "Jyske Bank",
    override val bankUrl: String = "www.jyskebank.dk",
    override val bankPhone: String = "+4589893300",
    override val bankCity: String = "Hjørring"
) : BinInfo