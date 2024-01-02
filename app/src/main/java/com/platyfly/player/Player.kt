package com.platyfly.player

import android.view.SurfaceView
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

class Player @Inject constructor(inputControls: InputControls, playerView: SurfaceView) : Runnable {
    // Interface to the player's movement system
    val input: InputControls = inputControls

    // The rendered image and its location on the screen
    var image: SurfaceView = playerView

    var running: AtomicBoolean = AtomicBoolean(false)

    /**
     * When an object implementing interface `Runnable` is used
     * to create a thread, starting the thread causes the object's
     * `run` method to be called in that separately executing
     * thread.
     *
     *
     * The general contract of the method `run` is that it may
     * take any action whatsoever.
     *
     * @see java.lang.Thread.run
     */
    override fun run() {
        running.set(true)
        while (running.get()) {
            updatePosition()
            animate()
        }
    }

    /**
     * Wraps logic around updating the position of the player based on the configured
     * input control system.
     */
    private fun updatePosition() {
        // Update the x coordinate to its right - left input difference
        val newX = image.x + (input.right() - input.left())
        image.x = Math.max(0.0f, newX)
    }

    private fun animate() {
        if (image.holder.surface.isValid) {
        }
        image.invalidate()
    }

    /**
     * Call to gracefully shut down the player and clean up any other resources.
     */
    fun shutdown() {
        running.set(false)
        image.holder.surface.release()
    }
}