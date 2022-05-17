package xyz.glorin.settingshubdemo.biz

import xyz.glorin.settingshubdemo.R
import xyz.glorin.settingshubdemo.settings.delegate.BaseSettingsPageDelegate
import xyz.glorin.settingshubdemo.settings.model.SettingsCategory
import xyz.glorin.settingshubdemo.settings.model.SettingsItem
import xyz.glorin.settingshubdemo.settings.model.SettingsPage

class SimpleSettingsPage :
    SettingsPage(PAGE_KEY, R.string.settings_name_simple, delegate) {

    init {
        addItem(
            SettingsCategory(
                "simple_category",
                R.string.settings_category_simple,
                0
            ).apply {
                addItem(
                    SettingsItem(
                        "simple_category_item",
                        R.string.settings_item_simple,
                        android.R.drawable.ic_input_add
                    )
                )
            })
    }

    companion object {
        const val PAGE_KEY = "simple"

        private val delegate = object : BaseSettingsPageDelegate() {

        }
    }
}