package com.platyfly.soar.hilt

import com.platyfly.player.InputControls
import com.platyfly.player.MotionControls
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RootModule {

    // TODO: Add logic for changing control scheme here
    @Binds
    abstract fun bindInputControlScheme(motionControlImpl: MotionControls): InputControls
}