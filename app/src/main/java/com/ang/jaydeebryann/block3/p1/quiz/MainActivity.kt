package com.ang.jaydeebryann.block3.p1.quiz

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_pause_play_song: ImageButton

        val mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.murders)

        btn_pause_play_song = findViewById(R.id.btn_pause_play_song)

        btn_pause_play_song.setOnClickListener {
            if(!mediaPlayer.isPlaying) {
                mediaPlayer.start()
                btn_pause_play_song.setImageResource(R.drawable.btn_pause_play_state)
            } else {
                mediaPlayer.pause()
                btn_pause_play_song.setImageResource(R.drawable.btn_pause_state)
            }
        }
    }
}