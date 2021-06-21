package model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Album(
    @SerializedName("userId") val userId: Int? = -1,
    @SerializedName("id") val id: Int? = -1,
    @SerializedName("title") val title: String? = "No title",
) : Serializable