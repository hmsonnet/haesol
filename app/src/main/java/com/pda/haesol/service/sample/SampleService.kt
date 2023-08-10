package com.pda.haesol.service.sample

import retrofit2.Call
import retrofit2.http.GET

interface SampleService {

    @GET("chart/list")
    fun getSampleList(): Call<List<Sample>>
}
