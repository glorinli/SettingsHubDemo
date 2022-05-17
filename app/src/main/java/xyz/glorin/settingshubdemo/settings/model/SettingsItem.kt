package xyz.glorin.settingshubdemo.settings.model

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.preference.Preference

open class SettingsItem(key: String, name: Int, val icon: Int) : BaseSettingsModel(key, name) {
    fun renderAsPreference(
        context: Context,
        clickListener: Preference.OnPreferenceClickListener,
        changeListener: Preference.OnPreferenceChangeListener
    ): Preference {
        return Preference(context).apply {
            key = this@SettingsItem.key
            title = context.getString(name)

            if (this@SettingsItem.icon != 0) {
                icon = ContextCompat.getDrawable(context, this@SettingsItem.icon)
            }

            onPreferenceClickListener = clickListener
            onPreferenceChangeListener = changeListener
        }
    }
}