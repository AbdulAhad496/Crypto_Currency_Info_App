package com.example.scratchlearning.presentation.coin_list

import com.example.scratchlearning.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coins : List<Coin> = emptyList(),
    val error : String = " "
)