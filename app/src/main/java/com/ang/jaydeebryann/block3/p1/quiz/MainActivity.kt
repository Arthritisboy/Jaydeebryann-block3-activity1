package com.ang.jaydeebryann.block3.p1.quiz

import android.graphics.Color
import android.graphics.PorterDuff
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import java.io.File


class MainActivity : AppCompatActivity() {

    lateinit var runnable: Runnable
    private var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        val songTitle: TextView = findViewById(R.id.songTitle)
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.viva_la_vida)

        val btn_pause_play_song: ImageButton = findViewById(R.id.btn_pause_play_song)
        val seekBar: SeekBar = findViewById(R.id.seekBar)

        seekBar.progressDrawable.setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN)
        seekBar.thumb.setColorFilter(Color.GREEN,PorterDuff.Mode.SRC_IN)

        seekBar.progress = 0

        seekBar.max = mediaPlayer.duration
        btn_pause_play_song.setOnClickListener {
            if(!mediaPlayer.isPlaying) {
                mediaPlayer.start()
                mediaPlayer.setLooping(true)
                songTitle.setText("Coldplay - Viva La Vida")
                btn_pause_play_song.setImageResource(R.drawable.btn_pause_play_state)
            } else {
                mediaPlayer.pause()
                btn_pause_play_song.setImageResource(R.drawable.btn_pause_state)
            }
        }
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p2) {
                    mediaPlayer.seekTo(p1)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        runnable = Runnable {
            seekBar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
        mediaPlayer.setOnCompletionListener {
            seekBar.progress = 0
        }
    }
}