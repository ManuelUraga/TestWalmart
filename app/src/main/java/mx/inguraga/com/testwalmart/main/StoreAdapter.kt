package mx.inguraga.com.testwalmart.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mx.inguraga.com.testwalmart.databinding.ViewMainItemBinding
import mx.inguraga.com.testwalmart.model.ResponseArray

class StoreAdapter(private val storesList: StoreListViewModel) :
        RecyclerView.Adapter<StoreViewHolder>(){

    var storeList: List<ResponseArray> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ViewMainItemBinding.inflate(inflater,parent,false)
        return StoreViewHolder(dataBinding,storesList)
    }

    override fun getItemCount(): Int = storeList.size

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.setUp(storeList[position])
    }

    fun updateStoreList(stores: List<ResponseArray>){
        this.storeList = stores
        notifyDataSetChanged()
    }
}