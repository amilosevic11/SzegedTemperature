package amilosevic.and.anovinc.ferit.temperatureprediction.api

import com.google.gson.annotations.SerializedName

data class Inputs(
    @SerializedName("input1")
    val input: Input
    )