package com.ulanapp.testrentateam.project.data.network

import com.ulanapp.testrentateam.project.data.model.UserResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ReqresApi {

    @GET("api/users")
    fun fetchUsers(): Observable<UserResponse>

}

object NetworkService {

    private const val BASE_URL = "https://reqres.in/"

    fun create(): ReqresApi {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(ReqresApi::class.java);
    }
}
