package xyz.glorin.settingshubdemo

import android.app.Application
import android.content.Context
import xyz.glorin.settingshubdemo.biz.SettingsDataController

class App : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

        application = this
    }

    override fun onCreate() {
        super.onCreate()

        SettingsDataController.initSettingsData()
    }

    companion object {
        lateinit var application: Application
    }
}