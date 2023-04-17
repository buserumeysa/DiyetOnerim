package com.buserkapkiner.diyetonerim.ui.model

import com.google.gson.annotations.SerializedName

data class Food(
    @SerializedName("isim")
    val foodName: String?,
    @SerializedName("kalori")
    val foodCalorie :String?,
    @SerializedName("karbonhidrat")
    val foodCarbohydrates :String?,
    @SerializedName("protein")
    val foodProtein :String?,
    @SerializedName("yag")
    val foodFat : String?,
    @SerializedName("gorsel")
    val foodImage: String?

    )
{

}
