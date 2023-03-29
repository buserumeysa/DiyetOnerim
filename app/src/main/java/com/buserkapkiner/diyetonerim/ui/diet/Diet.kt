package com.buserkapkiner.diyetonerim.ui.diet

var dietList = mutableListOf<Diet>()
val DIET_ID_EXTRA ="diet_extra"

class Diet (
    var imgDietPicture:Int,
    var txtDietTitle: String,
    var txtDietDescription : String,
    val id :Int? = dietList.size
)