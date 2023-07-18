package com.example.usersp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.usersp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //La data
        userAdapter = UserAdapter(getUsers())
        //El delegado que le pasa el contexto de quien implementa
        linearLayoutManager = LinearLayoutManager(this)

        binding.reciclerView.apply {
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }
    private fun getUsers(): MutableList<User> {
        var user = mutableListOf<User>()
        val carlos = User(1,"Carlos", "Rodriguez","")
        var lesly = User(2, "Lesly", "Mendoza", "")
        user.add(carlos)
        user.add(lesly)
        return user
    }
}