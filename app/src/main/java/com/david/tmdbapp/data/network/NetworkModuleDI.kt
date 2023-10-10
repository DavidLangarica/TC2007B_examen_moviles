import com.david.tmdbapp.data.TmdbAPIService
import com.david.tmdbapp.data.network.AuthInterceptor
import com.david.tmdbapp.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Generic network model for interacting with API services.
 *
 * This object provides a way to create instances of API services configured to communicate with various APIs.
 */
object NetworkModuleDI {
    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()

    /**
     * Creates an instance of the [TmdbAPIService] configured to communicate with the API.
     *
     * @param apiKey The API key to use when communicating with the API.
     * @return An instance of [TmdbAPIService].
     */
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