package com.kitesoft.kakaosearchapp.network

import com.kitesoft.kakaosearchapp.model.KeywordPlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface IRetrofitSearchPlaceService {

    @Headers("Authorization: KakaoAK d9e675595bca4b964abc6549664f5da8")
    @GET("/v2/local/search/keyword.json")
    fun searchPlacesByKeywordToString(@Query("query") keyword:String, @Query("x") longitude:String,@Query("y") latitude:String):Call<String>

    @Headers("Authorization: KakaoAK d9e675595bca4b964abc6549664f5da8")
    @GET("/v2/local/search/keyword.json")
    fun searchPlacesByKeyword(@Query("query") keyword:String, @Query("x") longitude:String,@Query("y") latitude:String):Call<KeywordPlaceResponse>

}