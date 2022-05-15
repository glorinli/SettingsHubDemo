package xyz.glorin.settingshubdemo.settings.model

class SettingsTab(key: String, name: Int) : BaseSettingsModel(key, name) {
    val items: MutableList<SettingsItem> = mutableListOf()
}