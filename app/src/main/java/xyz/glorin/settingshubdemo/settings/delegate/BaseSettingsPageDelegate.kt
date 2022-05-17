package xyz.glorin.settingshubdemo.settings.delegate

import androidx.preference.Preference

open class BaseSettingsPageDelegate : Preference.OnPreferenceClickListener,
    Preference.OnPreferenceChangeListener {
    override fun onPreferenceClick(preference: Preference?): Boolean {
        return false
    }

    override fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {
        return false
    }
}