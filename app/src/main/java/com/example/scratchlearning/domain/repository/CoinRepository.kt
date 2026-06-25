package com.example.scratchlearning.domain.repository

import com.example.scratchlearning.data.remote.dto.CoinDetailDto
import com.example.scratchlearning.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoin(): List<CoinDto>
    suspend fun getCoinbyId(coinId : String): CoinDetailDto

}