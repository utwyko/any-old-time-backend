package nl.wykorijnsburger.recordstores.anyoldtime

data class Record(
        val artistName: String,
        val title: String,
        val format: RecordFormat,
        val label: String,
        val country: String?,
        val releaseNumber: String?,
        val releaseYear: String,
        val condition: RecordCondition,
        val priceInEuro: String,
        val classification: String
)

enum class RecordFormat {
    LP
}

enum class RecordCondition(val displayName: String) {
    V("Very Good"),
    G("Good"),
    FG("Fair/almost good"),
    F("Fair"),
    FP("Fair/but prob. damaged"),
    P("Poor"),
    U("Unknown")
}