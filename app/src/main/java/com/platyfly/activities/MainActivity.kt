package com.platyfly.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.platyfly.activities.databinding.ActivityMainBinding
import com.platyfly.player.Player
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var player: Player

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewBinding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        player.image = binding.playerView
        player.run()
    }
}