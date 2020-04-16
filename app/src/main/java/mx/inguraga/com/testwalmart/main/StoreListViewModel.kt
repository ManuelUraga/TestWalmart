package mx.inguraga.com.testwalmart.main

import androidx.lifecycle.MutableLiveData
import mx.inguraga.com.testwalmart.model.ResponseArray

class StoreListViewModel  : BaseViewModel(){

    val storeListLive = MutableLiveData<List<ResponseArray>>()

    fun fetchRepoList(){
        dataLoading.value = true
        RepoRepository.getInstance().getWalmartStoreList{ isSuccess, response ->
            dataLoading.value = false
            if (isSuccess){
                storeListLive.value = response?.responseArray
                empty.value = false
            } else{
              empty.value = true
            }
        }

    }
}