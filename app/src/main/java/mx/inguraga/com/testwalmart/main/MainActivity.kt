package mx.inguraga.com.testwalmart.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import mx.inguraga.com.testwalmart.R
import mx.inguraga.com.testwalmart.databinding.ActivityMainBinding
import mx.inguraga.com.testwalmart.utils.longToast

class MainActivity : AppCompatActivity() {

    private lateinit var viewDataBinding: ActivityMainBinding
    private lateinit var adapter: StoreAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(StoreListViewModel::class.java)
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewDataBinding.viewmodel = viewModel

        viewModel.fetchRepoList()

        setupAdapter()
        setupObservers()

    }

    private fun setupObservers() {
        viewDataBinding.viewmodel?.storeListLive?.observe(this, Observer {
            adapter.updateStoreList(it)
        })

        viewDataBinding.viewmodel?.toastMessage?.observe(this,Observer{
            longToast(it)
        })
    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = StoreAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(this)
            list.layoutManager = layoutManager
            list.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
            list.adapter = adapter
        }
    }
}
