package xyz.glorin.settingshubdemo.biz

import xyz.glorin.settingshubdemo.settings.SettingsManager

object SettingsDataController {
    fun initSettingsData() {
        SettingsManager.registerSettingsPage(SimpleSettingsPage())
        SettingsManager.registerSettingsPage(TabbedSettingsPage())
    }
}