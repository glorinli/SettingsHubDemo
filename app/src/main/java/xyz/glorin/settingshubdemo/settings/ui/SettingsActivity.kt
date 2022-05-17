package xyz.glorin.settingshubdemo.settings.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.Preference
import xyz.glorin.settingshubdemo.R
import xyz.glorin.settingshubdemo.settings.SettingsManager
import xyz.glorin.settingshubdemo.settings.model.SettingsPage
import xyz.glorin.settingshubdemo.settings.renderer.SettingsPageRenderer
import java.lang.IllegalArgumentException

class SettingsActivity : AppCompatActivity(), SettingsFragment.Host {
    private lateinit var settingsPage: SettingsPage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        val key = intent.getStringExtra(EXTRA_KEY)

        if (key.isNullOrEmpty()) {
            throw IllegalArgumentException("Please specify a key")
        }

        settingsPage = SettingsManager.getPageByKey(key)
        SettingsPageRenderer.render(
            this,
            settingsPage,
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

    override fun getPreferenceClickListener(): Preference.OnPreferenceClickListener {
        return settingsPage.delegate
    }

    override fun getPreferenceChangeListener(): Preference.OnPreferenceChangeListener {
        return settingsPage.delegate
    }
}