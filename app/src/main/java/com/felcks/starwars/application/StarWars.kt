package com.felcks.starwars.application

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

internal class StarWars internal constructor(): Application() {

    override fun onCreate() {
        super.onCreate()

        context = this.applicationContext
    }

    internal companion object {

        internal var context: Context by Delegates.notNull()
            private set
    }
}