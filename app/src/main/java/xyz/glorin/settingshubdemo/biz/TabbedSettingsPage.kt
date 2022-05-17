package xyz.glorin.settingshubdemo.biz

import xyz.glorin.settingshubdemo.R
import xyz.glorin.settingshubdemo.settings.delegate.BaseSettingsPageDelegate
import xyz.glorin.settingshubdemo.settings.model.SettingsCategory
import xyz.glorin.settingshubdemo.settings.model.SettingsItem
import xyz.glorin.settingshubdemo.settings.model.SettingsPage
import xyz.glorin.settingshubdemo.settings.model.SettingsTab

class TabbedSettingsPage :
    SettingsPage(PAGE_KEY, R.string.settings_name_simple, delegate) {

    init {
        addTab(SettingsTab("tab_tab1", R.string.settings_tabbed_tab1).apply {
            addItem(
                SettingsCategory(
                    "tabbed_category",
                    R.string.settings_category_tab,
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
        })

        addTab(SettingsTab("tab_tab2", R.string.settings_tabbed_tab2).apply {
            addItem(
                SettingsCategory(
                    "tabbed_category2",
                    R.string.settings_category_tab2,
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
        })
    }

    companion object {
        const val PAGE_KEY = "tabbed"

        private val delegate = object : BaseSettingsPageDelegate() {

        }
    }
}