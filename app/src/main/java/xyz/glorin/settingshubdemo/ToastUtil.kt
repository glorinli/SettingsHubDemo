package xyz.glorin.settingshubdemo

import android.widget.Toast
import androidx.annotation.StringRes

object ToastUtil {
    fun showToast(@StringRes message: Int) {
        Toast.makeText(App.application, message, Toast.LENGTH_SHORT).show()
    }

    fun showToast(message: CharSequence) {
        Toast.makeText(App.application, message, Toast.LENGTH_SHORT).show()
    }
}