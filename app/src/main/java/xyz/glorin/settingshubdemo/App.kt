package xyz.glorin.settingshubdemo

import android.app.Application
import xyz.glorin.settingshubdemo.settings.SettingsManager
import xyz.glorin.settingshubdemo.settings.model.SettingsCategory
import xyz.glorin.settingshubdemo.settings.model.SettingsItem
import xyz.glorin.settingshubdemo.settings.model.SettingsPage
import xyz.glorin.settingshubdemo.settings.model.SettingsTab

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
            })

        SettingsManager.registerSettingsPage(
            SettingsPage(
                "tabbed",
                R.string.settings_name_tabbed
            ).apply {
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
            })
    }
}