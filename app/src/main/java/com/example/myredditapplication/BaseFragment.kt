package com.example.myredditapplication

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment


abstract class BaseFragment : Fragment() {
    /**
     * Default font scale for used when app font scale change
     */
    val DEFAULT_FONT_SCALE = 1.0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onStart() {
        try {
            super.onStart()
        } catch (e: Exception) {
        }

    }

    override fun onResume() {
        super.onResume()
        adjustFontScale(resources.configuration)
    }

    private fun adjustFontScale(configuration: Configuration) {
        if (configuration.fontScale > DEFAULT_FONT_SCALE) {
            configuration.fontScale = DEFAULT_FONT_SCALE
            val metrics = resources.displayMetrics
            val wm = requireContext().getSystemService(Context.WINDOW_SERVICE) as WindowManager
            wm.defaultDisplay.getMetrics(metrics)
            metrics.scaledDensity = configuration.fontScale * metrics.density
            requireContext().resources.updateConfiguration(configuration, metrics)
        }
    }

}