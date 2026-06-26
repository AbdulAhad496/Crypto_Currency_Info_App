package com.example.scratchlearning.domain.use_case.get_coins

import com.example.scratchlearning.common.Resource
import com.example.scratchlearning.data.remote.dto.toCoin
import com.example.scratchlearning.domain.model.Coin
import com.example.scratchlearning.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository : CoinRepository

){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoin().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e : HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage?: "An Unexpected Error Occured"))
        } catch (e: IOException){
            emit(Resource.Error("Could'nt reach server.Check Your Internet Connection"))
        }
    }
}