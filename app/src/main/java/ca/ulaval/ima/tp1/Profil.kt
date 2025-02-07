import android.os.Parcel
import android.os.Parcelable
import java.util.Calendar

class Profil(
    val nom: String,
    val prenom: String,
    val dateNaissance: Calendar,
    val idul: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        Calendar.getInstance().apply { timeInMillis = parcel.readLong() },
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nom)
        parcel.writeString(prenom)
        parcel.writeLong(dateNaissance.timeInMillis)
        parcel.writeString(idul)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Profil> {
        override fun createFromParcel(parcel: Parcel): Profil {
            return Profil(parcel)
        }

        override fun newArray(size: Int): Array<Profil?> {
            return arrayOfNulls(size)
        }
    }
}