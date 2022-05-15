package xyz.glorin.settingshubdemo.settings

import xyz.glorin.settingshubdemo.settings.model.SettingsPage
import java.lang.IllegalArgumentException
import java.util.concurrent.ConcurrentHashMap

object SettingsManager {
    private val pageMap: ConcurrentHashMap<String, SettingsPage> = ConcurrentHashMap()

    fun registerSettingsPage(page: SettingsPage) {
        if (pageMap.containsKey(page.key)) {
            throw IllegalArgumentException("Key ${page.key} already registered!")
        }

        pageMap[page.key] = page
    }

    fun getPageByKey(key: String): SettingsPage {
        return pageMap[key] ?: throw IllegalArgumentException("Key $key does not exists")
    }
}