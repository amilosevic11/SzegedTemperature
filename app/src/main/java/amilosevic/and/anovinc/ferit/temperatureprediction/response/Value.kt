package amilosevic.and.anovinc.ferit.temperatureprediction.response

data class Value(
    val ColumnNames: List<String>,
    val ColumnTypes: List<String>,
    val Values: List<List<String>>
)
