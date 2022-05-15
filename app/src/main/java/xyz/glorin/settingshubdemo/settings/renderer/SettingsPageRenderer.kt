package xyz.glorin.settingshubdemo.settings.renderer

import android.content.Context
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceGroup
import androidx.preference.PreferenceManager
import androidx.preference.PreferenceScreen
import xyz.glorin.settingshubdemo.settings.model.SettingsCategory
import xyz.glorin.settingshubdemo.settings.model.SettingsItem
import xyz.glorin.settingshubdemo.settings.model.SettingsPage
import xyz.glorin.settingshubdemo.settings.ui.SettingsFragment

object SettingsPageRenderer {
    fun render(
        context: Context,
        page: SettingsPage,
        container: ViewGroup,
        fragmentManager: FragmentManager
    ) {
        if (page.settingsTabs.isEmpty()) {
            // Create fragment directly
            fragmentManager.beginTransaction()
                .add(container.id, SettingsFragment.create(page.settingsItems))
                .commitAllowingStateLoss()
        } else {
            // Create ViewPager
        }
    }

    fun createPreferenceScreen(
        context: Context,
        preferenceManager: PreferenceManager,
        items: List<SettingsItem>
    ): PreferenceScreen {
        return preferenceManager.createPreferenceScreen(context).apply {
            items.forEach {
                if (it is SettingsCategory) {
                    val preferenceCategory = PreferenceCategory(context).apply {
                        title = context.getString(it.name)
                    }

                    addPreference(preferenceCategory)

                    it.settingsItems.forEach { item ->
                        preferenceCategory.addSettingsItem(context, item)
                    }
                } else {
                    addSettingsItem(context, it)
                }
            }
        }
    }

    private fun PreferenceGroup.addSettingsItem(
        context: Context,
        item: SettingsItem
    ) {
        addPreference(Preference(context).apply {
            title = context.getString(item.name)
        })
    }
}