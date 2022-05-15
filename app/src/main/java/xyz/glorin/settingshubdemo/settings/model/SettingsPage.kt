package xyz.glorin.settingshubdemo.settings.model

import java.lang.IllegalArgumentException

class SettingsPage(key: String, name: Int) : BaseSettingsModel(key, name) {
    private val tabs: ArrayList<SettingsTab> = ArrayList()
    private val items: ArrayList<SettingsItem> = ArrayList()

    val settingsItems = items
    val settingsTabs = tabs

    fun addTab(tab: SettingsTab) {
        if (tabs.find { it.key == tab.key } != null) throw IllegalArgumentException("Key ${tab.key} already taken")

        tabs.add(tab)
    }

    fun addItem(item: SettingsItem) {
        if (items.find { it.key == item.key } != null) throw IllegalArgumentException("Key ${item.key} already taken")

        items.add(item)
    }
}