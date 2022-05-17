package xyz.glorin.settingshubdemo.settings.delegate

import androidx.preference.Preference
import xyz.glorin.settingshubdemo.ToastUtil

open class BaseSettingsPageDelegate : Preference.OnPreferenceClickListener,
    Preference.OnPreferenceChangeListener {
    override fun onPreferenceClick(preference: Preference?): Boolean {
        ToastUtil.showToast("Preference clicked: ${preference?.key}")
        return false
    }

    override fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {
        ToastUtil.showToast("Preference changed: ${preference?.key}: $newValue")
        return false
    }
}