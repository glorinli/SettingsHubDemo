package xyz.glorin.settingshubdemo.settings.model

import androidx.annotation.StringRes

open class BaseSettingsModel(val settingsKey: String, @StringRes val settingsName: Int) {
    /**
     * Chain of keys
     */
    val path: MutableList<String> = mutableListOf()

    var visible: Boolean = true
}