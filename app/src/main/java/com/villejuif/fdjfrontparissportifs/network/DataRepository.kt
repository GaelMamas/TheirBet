package com.villejuif.fdjfrontparissportifs.network

import com.villejuif.fdjfrontparissportifs.data.model.LeagueModel
import com.villejuif.fdjfrontparissportifs.data.model.Team
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(private val mRemoteDataProvider: RemoteDataProvider) {

    suspend fun searchAllTeamsAsync(league:String):Result<List<Team?>?>{
        val result = mRemoteDataProvider.searchAllTeamsAsync(league)

         if(result is Result.Error)
            throw result.exception

        return result
    }

    suspend fun searchTeamsAsync(team:String):Result<List<Team?>?>{
        val result = mRemoteDataProvider.searchTeamsAsync(team)

        if(result is Result.Error)
            throw result.exception

        return result
    }

    suspend fun getAllLeaguesAsync():Result<List<LeagueModel?>?>{
        val result = mRemoteDataProvider.getAllLeaguesAsync()

        if(result is Result.Error)
            throw result.exception

        return result
    }


}