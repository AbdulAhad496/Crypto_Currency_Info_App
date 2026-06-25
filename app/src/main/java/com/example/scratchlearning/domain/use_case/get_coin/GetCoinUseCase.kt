package com.example.scratchlearning.domain.use_case.get_coin

import com.example.scratchlearning.common.Resource
import com.example.scratchlearning.data.remote.dto.toCoin
import com.example.scratchlearning.data.remote.dto.toCoinDetail
import com.example.scratchlearning.domain.model.Coin
import com.example.scratchlearning.domain.model.CoinDetail
import com.example.scratchlearning.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository : CoinRepository

){
    operator fun invoke(coinId : String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinbyId(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage?: "An Unexpected Error Occured"))
        } catch (e: IOException){
            emit(Resource.Error("Could'nt reach server.Check Your Internet Connection"))
        }
    }
}