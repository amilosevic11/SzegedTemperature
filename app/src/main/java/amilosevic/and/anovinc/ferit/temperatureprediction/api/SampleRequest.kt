package amilosevic.and.anovinc.ferit.temperatureprediction.api

import com.google.gson.annotations.SerializedName

data class SampleRequest(
    @SerializedName("Inputs")
    val inputs: Inputs,
    @SerializedName("GlobalParameters")
    val globalParameters: HashMap<String,String>
    )