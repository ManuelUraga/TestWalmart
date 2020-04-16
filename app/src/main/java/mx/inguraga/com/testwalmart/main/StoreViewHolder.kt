package mx.inguraga.com.testwalmart.main

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import mx.inguraga.com.testwalmart.BR
import mx.inguraga.com.testwalmart.model.ResponseArray
import org.jetbrains.anko.bundleOf
import org.jetbrains.anko.sdk27.coroutines.onClick

class StoreViewHolder constructor(private val dataBinding: ViewDataBinding, private val repoListViewModel: StoreListViewModel)
    : RecyclerView.ViewHolder(dataBinding.root){

    fun setUp(itemData : ResponseArray){
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()
        itemView.onClick {
            var bundle = bundleOf("url" to itemData.storeID)
        }
    }

}