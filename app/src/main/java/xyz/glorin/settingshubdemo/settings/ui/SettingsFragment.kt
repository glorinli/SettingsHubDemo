package xyz.glorin.settingshubdemo.settings.ui

import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import xyz.glorin.settingshubdemo.settings.model.SettingsItem
import xyz.glorin.settingshubdemo.settings.renderer.SettingsPageRenderer

class SettingsFragment : PreferenceFragmentCompat() {
    private val settingsItems = mutableListOf<SettingsItem>()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        arguments?.getParcelableArrayList<SettingsItem>(EXTRA_ITEMS)?.forEach {
            settingsItems.add(it)
        }

        val host = requireActivity() as? Host
            ?: throw IllegalStateException("Should put this fragment in a Host")

        preferenceScreen = SettingsPageRenderer.createPreferenceScreen(
            requireContext(),
            preferenceManager,
            settingsItems,
            host.getPreferenceClickListener(),
            host.getPreferenceChangeListener()
        )
    }

    companion object {
        private const val EXTRA_ITEMS = "items"

        fun create(items: ArrayList<SettingsItem>): SettingsFragment {
            return SettingsFragment().apply {
                arguments = Bundle().apply { putParcelableArrayList(EXTRA_ITEMS, items) }
            }
        }
    }

    interface Host {
        fun getPreferenceClickListener(): Preference.OnPreferenceClickListener
        fun getPreferenceChangeListener(): Preference.OnPreferenceChangeListener
    }
}