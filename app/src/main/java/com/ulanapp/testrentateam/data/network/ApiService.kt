package com.ulanapp.testrentateam.data.network

import com.ulanapp.testrentateam.data.models.UserResponse
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UsersApi {

    @GET("api/users")
    fun fetchUsers(): Observable<UserResponse>

}

object NetworkService {

    private const val BASE_URL = "https://reqres.in/"

    fun create(): UsersApi {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(UsersApi::class.java);
    }
}