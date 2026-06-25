package com.example.scratchlearning.data.repository

import com.example.scratchlearning.data.remote.CoinPaprikaApi
import com.example.scratchlearning.data.remote.dto.CoinDetailDto
import com.example.scratchlearning.data.remote.dto.CoinDto
import com.example.scratchlearning.domain.repository.CoinRepository
import retrofit2.http.Path
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
): CoinRepository{

    override suspend fun getCoin(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinbyId(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}