package xyz.glorin.settingshubdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import xyz.glorin.settingshubdemo.settings.ui.SettingsActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btnShowSimpleSettings).setOnClickListener(this)
        findViewById<View>(R.id.btnShowSettingsWithTab).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnShowSimpleSettings -> SettingsActivity.show(this, "simple")
            R.id.btnShowSettingsWithTab -> SettingsActivity.show(this, "tabbed")
        }
    }
}