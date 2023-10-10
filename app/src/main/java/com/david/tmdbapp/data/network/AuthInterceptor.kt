package com.david.tmdbapp.data.network

import okhttp3.Interceptor
import okhttp3.Response


/*
 * Class that intercepts the request and adds the authorization header
*/
class AuthInterceptor(private val authToken: String) : Interceptor {

    /*
     * Function that intercepts the request and adds the authorization header
     *
     * @param chain: Interceptor.Chain
     * @return Response
    */
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $authToken")
            .build()
        return chain.proceed(request)
    }
}
