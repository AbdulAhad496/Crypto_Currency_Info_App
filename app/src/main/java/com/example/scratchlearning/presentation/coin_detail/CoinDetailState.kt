package com.example.scratchlearning.presentation.coin_detail

import com.example.scratchlearning.domain.model.Coin
import com.example.scratchlearning.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coin : CoinDetail? = null,
    val error : String = " "
)