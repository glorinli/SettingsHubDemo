package xyz.glorin.settingshubdemo

import android.app.Application
import xyz.glorin.settingshubdemo.settings.SettingsManager
import xyz.glorin.settingshubdemo.settings.model.SettingsCategory
import xyz.glorin.settingshubdemo.settings.model.SettingsItem
import xyz.glorin.settingshubdemo.settings.model.SettingsPage

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initSettingsData()
    }

    private fun initSettingsData() {
        SettingsManager.registerSettingsPage(
            SettingsPage(
                "simple",
                R.string.settings_name_simple
            ).apply {
                addItem(SettingsCategory("simple_category", R.string.settings_category_simple).apply {
                    addItem(SettingsItem("simple_category_item", R.string.settings_item_simple))
                })
            })

        SettingsManager.registerSettingsPage(
            SettingsPage(
                "tabbed",
                R.string.settings_name_tabbed
            ).apply {
                addItem(SettingsCategory("tabbed_category", R.string.settings_category_tab))
            })
    }
}