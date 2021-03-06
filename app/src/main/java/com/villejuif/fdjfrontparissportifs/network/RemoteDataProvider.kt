package com.villejuif.fdjfrontparissportifs.network

import com.villejuif.fdjfrontparissportifs.data.model.LeagueModel
import com.villejuif.fdjfrontparissportifs.data.model.Team
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataProvider @Inject constructor(private val mTheSportsDBApi: TheSportsDBApi) {
    suspend fun searchAllTeamsAsync(league: String): Result<List<Team?>?> {
        val result: Result<List<Team?>?>
        result = try {
            Result.Success(mTheSportsDBApi.retrofitService.searchAllTeamsAsync(league).await().teams)
        }catch (e:Exception){
            Result.Error(e)
        }

        return result
    }

    suspend fun searchTeamsAsync(team: String): Result<List<Team?>?> {
        val result: Result<List<Team?>?>
        result = try {
            Result.Success(mTheSportsDBApi.retrofitService.searchTeamsAsync(team).await().teams)
        }catch (e:Exception){
            Result.Error(e)
        }

        return result
    }

    suspend fun getAllLeaguesAsync(): Result<List<LeagueModel?>?> {
        val result: Result<List<LeagueModel?>?>
        result = try {
            Result.Success(mTheSportsDBApi.retrofitService.getAllLeaguesAsync().await().leagues)
        }catch (e:Exception){
            Result.Error(e)
        }

        return result
    }
}