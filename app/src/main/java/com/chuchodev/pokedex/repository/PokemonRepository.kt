package com.chuchodev.pokedex.repository

import com.chuchodev.pokedex.data.remote.PokeAPI
import com.chuchodev.pokedex.data.remote.response.Pokemon
import com.chuchodev.pokedex.data.remote.response.PokemonList
import com.chuchodev.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeAPI
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("Ha ocurrido un error")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception){
            return Resource.Error("Ha ocurrido un error")
        }
        return Resource.Success(response)
    }

}