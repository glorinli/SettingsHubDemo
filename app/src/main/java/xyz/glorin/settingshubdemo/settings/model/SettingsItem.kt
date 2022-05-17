package xyz.glorin.settingshubdemo.settings.model

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.preference.Preference

open class SettingsItem(key: String, name: Int, val itemIcon: Int) : BaseSettingsModel(key, name) {
    open fun renderAsPreference(
        context: Context,
        clickListener: Preference.OnPreferenceClickListener,
        changeListener: Preference.OnPreferenceChangeListener
    ): Preference {
        return Preference(context).apply {
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