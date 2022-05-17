package xyz.glorin.settingshubdemo.settings

import xyz.glorin.settingshubdemo.settings.model.SettingsPage
import java.lang.IllegalArgumentException
import java.util.concurrent.ConcurrentHashMap

object SettingsManager {
    private val pageMap: ConcurrentHashMap<String, SettingsPage> = ConcurrentHashMap()

    fun registerSettingsPage(page: SettingsPage) {
        if (pageMap.containsKey(page.settingsKey)) {
            throw IllegalArgumentException("Key ${page.settingsKey} already registered!")
        }

        pageMap[page.settingsKey] = page
    }

    fun getPageByKey(key: String): SettingsPage {
        return pageMap[key] ?: throw IllegalArgumentException("Key $key does not exists")
    }
}