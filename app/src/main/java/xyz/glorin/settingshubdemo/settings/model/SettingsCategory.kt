package xyz.glorin.settingshubdemo.settings.model

import android.os.Parcel
import android.os.Parcelable
import java.lang.IllegalArgumentException

class SettingsCategory(key: String, name: Int) : SettingsItem(key, name), Parcelable {
    private val items: MutableList<SettingsItem> = mutableListOf()

    val settingsItems = items

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt()
    ) {
        parcel.readArray(SettingsItem::class.java.classLoader)?.forEach {
            if (it is SettingsItem) {
                items.add(it)
            }
        }
    }

    fun addItem(item: SettingsItem) {
        if (items.find { it.key == item.key } != null) throw IllegalArgumentException("Key ${item.key} already taken")

        items.add(item)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)

        parcel.writeArray(items.toTypedArray())
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SettingsCategory> {
        override fun createFromParcel(parcel: Parcel): SettingsCategory {
            return SettingsCategory(parcel)
        }

        override fun newArray(size: Int): Array<SettingsCategory?> {
            return arrayOfNulls(size)
        }
    }
}