package xyz.glorin.settingshubdemo.settings.ui

import android.os.Bundle
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceFragmentCompat
import xyz.glorin.settingshubdemo.settings.model.SettingsCategory
import xyz.glorin.settingshubdemo.settings.model.SettingsItem
import xyz.glorin.settingshubdemo.settings.renderer.SettingsPageRenderer

class SettingsFragment : PreferenceFragmentCompat() {
    private val settingsItems = mutableListOf<SettingsItem>()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        arguments?.getParcelableArrayList<SettingsItem>(EXTRA_ITEMS)?.forEach {
            settingsItems.add(it)
        }

        preferenceScreen = SettingsPageRenderer.createPreferenceScreen(requireContext(), preferenceManager, settingsItems)
    }

    companion object {
        private const val EXTRA_ITEMS = "items"

        fun create(items: ArrayList<SettingsItem>): SettingsFragment {
            return SettingsFragment().apply {
                arguments = Bundle().apply { putParcelableArrayList(EXTRA_ITEMS, items) }
            }
        }
    }
}