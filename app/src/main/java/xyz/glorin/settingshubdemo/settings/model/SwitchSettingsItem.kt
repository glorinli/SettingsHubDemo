package xyz.glorin.settingshubdemo.settings.model

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.preference.Preference
import androidx.preference.SwitchPreference

class SwitchSettingsItem(key: String, name: Int, icon: Int) : SettingsItem(key, name, icon) {
    override fun renderAsPreference(
        context: Context,
        clickListener: Preference.OnPreferenceClickListener,
        changeListener: Preference.OnPreferenceChangeListener
    ): Preference {
        return SwitchPreference(context).apply {
            key = settingsKey
            title = context.getString(settingsName)

            if (itemIcon != 0) {
                icon = ContextCompat.getDrawable(context, itemIcon)
            }

            onPreferenceClickListener = clickListener
            onPreferenceChangeListener = changeListener
        }
    }
}