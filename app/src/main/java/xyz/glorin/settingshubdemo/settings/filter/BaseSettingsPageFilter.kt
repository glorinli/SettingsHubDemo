package xyz.glorin.settingshubdemo.settings.filter

import xyz.glorin.settingshubdemo.settings.model.SettingsPage

abstract class BaseSettingsPageFilter {
    abstract fun filterPage(page: SettingsPage)
}