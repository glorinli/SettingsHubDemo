package xyz.glorin.settingshubdemo.settings.model

class SettingsCategory(key: String, name: Int, icon: Int) : SettingsItem(key, name, icon) {
    private val items: MutableList<SettingsItem> = mutableListOf()

    val settingsItems = items

    fun addItem(item: SettingsItem) {
        if (items.find { it.key == item.key } != null) throw IllegalArgumentException("Key ${item.key} already taken")

        items.add(item)
    }
}