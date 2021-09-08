package amilosevic.and.anovinc.ferit.temperatureprediction.api

import com.google.gson.annotations.SerializedName
import org.json.JSONArray

data class Input(@SerializedName("ColumnNames")
                 val columnNames: List<String>?,
                 @SerializedName("Values")
                 val values: List<List<String>>?)