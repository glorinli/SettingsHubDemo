package xyz.glorin.settingshubdemo.settings.ui

import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import xyz.glorin.settingshubdemo.settings.SettingsManager
import xyz.glorin.settingshubdemo.settings.model.SettingsItem
import xyz.glorin.settingshubdemo.settings.renderer.SettingsPageRenderer
import java.lang.IllegalArgumentException

class SettingsFragment : PreferenceFragmentCompat() {
    private lateinit var settingsItems: List<SettingsItem>

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val pageKey = arguments?.getString(EXTRA_PAGE_KEY)
        val tabKey = arguments?.getString(EXTRA_TAB_KEY)

        if (pageKey.isNullOrEmpty()) {
            throw IllegalArgumentException("Page key is required")
        }

        val page = SettingsManager.getPageByKey(pageKey)

        if (tabKey.isNullOrEmpty()) {
            settingsItems = page.settingsItems
        } else {
            settingsItems = page.settingsTabs.find { it.key == tabKey }?.settingsItems ?: listOf()
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
        private const val EXTRA_TAB_KEY = "tab"
        private const val EXTRA_PAGE_KEY = "page"

        fun create(pageKey: String, tabKey: String?): SettingsFragment {
            return SettingsFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_PAGE_KEY, pageKey)
                    putString(EXTRA_TAB_KEY, tabKey)
                }
            }
        }
    }

    interface Host {
        fun getPreferenceClickListener(): Preference.OnPreferenceClickListener
        fun getPreferenceChangeListener(): Preference.OnPreferenceChangeListener
    }
}