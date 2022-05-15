package xyz.glorin.settingshubdemo.settings.model

import androidx.annotation.StringRes

open class BaseSettingsModel(val key: String, @StringRes val name: Int) {
    /**
     * Chain of keys
     */
    val path: MutableList<String> = mutableListOf()

    var visible: Boolean = true
}