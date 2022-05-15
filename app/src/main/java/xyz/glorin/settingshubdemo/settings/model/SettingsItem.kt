package xyz.glorin.settingshubdemo.settings.model

import android.os.Parcel
import android.os.Parcelable

open class SettingsItem(key: String, name: Int, val icon: Int) : BaseSettingsModel(key, name), Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(key)
        parcel.writeInt(name)
        parcel.writeInt(icon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SettingsItem> {
        override fun createFromParcel(parcel: Parcel): SettingsItem {
            return SettingsItem(parcel)
        }

        override fun newArray(size: Int): Array<SettingsItem?> {
            return arrayOfNulls(size)
        }
    }
}