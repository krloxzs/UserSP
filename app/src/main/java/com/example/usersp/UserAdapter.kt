package com.example.usersp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usersp.databinding.ItemUserBinding
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent

//El adapter seria como una extension que implementa protocolos
class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    private lateinit var context: Context

    //Similar a cellforrowat
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    var user = users[position]
        with(holder){
            binding.tvOrder.text = user.id.toString()
            binding.tvName.text = user.name
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    //es un simil a una celda  RecyclerView.ViewHolder
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
     val binding = ItemUserBinding.bind(view)
    }

}