package xyz.glorin.settingshubdemo.settings.renderer

import android.content.Context
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceGroup
import androidx.preference.PreferenceManager
import androidx.preference.PreferenceScreen
import androidx.viewpager.widget.ViewPager
import xyz.glorin.settingshubdemo.R
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
                .add(container.id, SettingsFragment.create(page.key, null))
                .commitAllowingStateLoss()
        } else {
            // Create ViewPager
            LayoutInflater.from(context).inflate(R.layout.settings_tab_layout, container)

            val viewPager = container.findViewById<ViewPager>(R.id.viewPager)
            viewPager.adapter = object : FragmentPagerAdapter(
                fragmentManager,
                BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
            ) {
                private val fragments = SparseArray<Fragment>()

                override fun getCount(): Int {
                    return page.settingsTabs.size
                }

                override fun getItem(position: Int): Fragment {
                    return fragments[position]
                        ?: SettingsFragment.create(page.key, page.settingsTabs[position].key).also {
                            fragments[position] = it
                        }
                }

                override fun getPageTitle(position: Int): CharSequence {
                    return context.getString(page.settingsTabs[position].name)
                }

            }
        }
    }

    fun createPreferenceScreen(
        context: Context,
        preferenceManager: PreferenceManager,
        items: List<SettingsItem>,
        preferenceClickListener: Preference.OnPreferenceClickListener,
        preferenceChangeListener: Preference.OnPreferenceChangeListener
    ): PreferenceScreen {
        return preferenceManager.createPreferenceScreen(context).apply {
            items.forEach {
                if (it is SettingsCategory) {
                    val preferenceCategory = PreferenceCategory(context).apply {
                        title = context.getString(it.name)
                    }

                    addPreference(preferenceCategory)

                    it.settingsItems.forEach { item ->
                        preferenceCategory.addSettingsItem(
                            context,
                            item,
                            preferenceClickListener,
                            preferenceChangeListener
                        )
                    }
                } else {
                    addSettingsItem(context, it, preferenceClickListener, preferenceChangeListener)
                }
            }
        }
    }

    private fun PreferenceGroup.addSettingsItem(
        context: Context,
        item: SettingsItem,
        preferenceClickListener: Preference.OnPreferenceClickListener,
        preferenceChangeListener: Preference.OnPreferenceChangeListener
    ) {
        addPreference(
            item.renderAsPreference(
                context,
                preferenceClickListener,
                preferenceChangeListener
            )
        )
    }
}