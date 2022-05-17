package xyz.glorin.settingshubdemo.settings.model

import xyz.glorin.settingshubdemo.settings.delegate.BaseSettingsPageDelegate
import java.lang.IllegalArgumentException

open class SettingsPage(key: String, name: Int, val delegate: BaseSettingsPageDelegate) : BaseSettingsModel(key, name) {
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