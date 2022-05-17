package xyz.glorin.settingshubdemo

import android.app.Application
import xyz.glorin.settingshubdemo.biz.SettingsDataController

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        SettingsDataController.initSettingsData()
    }
}