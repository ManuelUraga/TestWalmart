package mx.inguraga.com.testwalmart.main

import android.preference.PreferenceManager
import mx.inguraga.com.testwalmart.api.ApiClient
import mx.inguraga.com.testwalmart.model.WalmartStore
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RepoRepository {

    fun getWalmartStoreList(onResult :(isSuccess: Boolean, response: WalmartStore?)->Unit){
        ApiClient.instance.getStores().enqueue(object : Callback<WalmartStore> {
            override fun onResponse(call: Call<WalmartStore>?, response: Response<WalmartStore>?){
                if (response != null && response.isSuccessful){
                    onResult(true, response.body()!!)
                }else
                    onResult(false,null)
            }

            override fun onFailure(call: Call<WalmartStore>, t: Throwable) {
                onResult(false,null)
            }
        })
    }

    companion object{
        private var INSTANCE: RepoRepository ? = null
        fun getInstance() = INSTANCE
                ?:RepoRepository().also {
                    INSTANCE = it
                }
    }
}