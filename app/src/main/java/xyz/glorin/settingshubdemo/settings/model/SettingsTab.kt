package xyz.glorin.settingshubdemo.settings.model

import java.lang.IllegalArgumentException

class SettingsTab(key: String, name: Int) : BaseSettingsModel(key, name) {
    private val items: ArrayList<SettingsItem> = ArrayList()

    val settingsItems = items

    fun addItem(item: SettingsItem) {
        if (items.find { it.key == item.key } != null) throw IllegalArgumentException("Key ${item.key} already taken")

        items.add(item)
    }
}