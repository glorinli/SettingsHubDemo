package xyz.glorin.settingshubdemo.settings.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.glorin.settingshubdemo.R
import xyz.glorin.settingshubdemo.settings.SettingsManager
import xyz.glorin.settingshubdemo.settings.renderer.SettingsPageRenderer
import java.lang.IllegalArgumentException

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        val key = intent.getStringExtra(EXTRA_KEY)

        if (key.isNullOrEmpty()) {
            throw IllegalArgumentException("Please specify a key")
        }

        val page = SettingsManager.getPageByKey(key)
        SettingsPageRenderer.render(
            this,
            page,
            findViewById(R.id.settingsContainer),
            supportFragmentManager
        )
    }

    companion object {
        private const val EXTRA_KEY = "key"

        fun show(context: Context, key: String) {
            context.startActivity(Intent(context, SettingsActivity::class.java).apply {
                putExtra(EXTRA_KEY, key)
            })
        }
    }
}