package com.pda.haesol.service.sample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Retrofit 인스턴스를 생성하고 관리하는 싱글톤 클래스
object RetrofitInstance {
    private const val BASE_URL = "http://192.168.2.121:9820/" // 서버의 기본 URL

    // Retrofit 인스턴스 생성
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL) // 서버 기본 URL 설정
        .addConverterFactory(GsonConverterFactory.create()) // JSON 파싱을 위한 컨버터 설정
        .build()

    // SampleService 인터페이스의 구현체 생성
    val sampleService: SampleService = retrofit.create(SampleService::class.java)
}