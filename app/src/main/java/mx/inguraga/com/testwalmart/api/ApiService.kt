package mx.inguraga.com.testwalmart.api

import mx.inguraga.com.testwalmart.model.WalmartStore
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("address/storeLocatorCoordinates")
    fun getStores(): Call<WalmartStore>
}