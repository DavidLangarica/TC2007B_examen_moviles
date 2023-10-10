import com.david.tmdbapp.data.TmdbAPIService
import com.david.tmdbapp.data.network.AuthInterceptor
import com.david.tmdbapp.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModuleDI {
    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()

    operator fun invoke(apiKey: String): TmdbAPIService {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(apiKey))
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(TmdbAPIService::class.java)
    }
}