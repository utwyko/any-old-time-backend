package nl.wykorijnsburger.recordstores.anyoldtime

import java.io.InputStream

val DEFAULT_LINE_LENGTH = 8

fun InputStream.parse(): List<Record> {
    val records = mutableListOf<Record>()

    bufferedReader()
            .useLines {
                it.forEach {
                    val element = it.toRecord()

                    println("element = ${element}")
                    if (element != null) {
                        records.add(element)
                    }
                }
            }

    return records
}

private fun String.toRecord(): Record? {
    val splitString = split(", ")

    if (splitString.size == DEFAULT_LINE_LENGTH) {

        val labelWithCountryAndReleaseNumber = splitString[3]
        val splitLabelWithCountryAndReleaseNumber = labelWithCountryAndReleaseNumber.split("(", ")")

        var country: String? = null
        var releaseNumber: String? = null
        if (splitLabelWithCountryAndReleaseNumber.size == 3) {
            country = splitLabelWithCountryAndReleaseNumber[1]
            releaseNumber = splitLabelWithCountryAndReleaseNumber[2]
        }

        return Record(
                artistName = splitString[0].replace("-.-.-", ""),
                title = splitString[1],
                format = RecordFormat.LP,
                condition = splitString[5].toCondition(),
                country = country,
                releaseNumber = releaseNumber,
                releaseYear = splitString[4],
                label = splitLabelWithCountryAndReleaseNumber[0],
                priceInEuro = splitString[6],
                classification = splitString[7]
        )
    }

    return null
}

private fun String.toCondition(): RecordCondition {
    val condition = split("/", "(").first().trim()

    return when (condition) {
        "F-" -> RecordCondition.FP
        "F+" -> RecordCondition.FG
        "Poor" -> RecordCondition.P
        else -> try {
            RecordCondition.valueOf(condition)
        } catch (e: IllegalArgumentException) {
            RecordCondition.U
        }
    }
}
