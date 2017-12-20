package nl.wykorijnsburger.recordstores.anyoldtime

import org.springframework.stereotype.Service

@Service
class AnyOldTimeService(val anyOldTimeClient: AnyOldTimeClient) {

    val records = javaClass.classLoader.getResource("anyoldtime_WWW-LP.txt")
            .openStream()
            .parse()

    fun searchRecords(searchTerm: String? = null): List<Record> {
        if (searchTerm != null) {
            return records.filter {
                it.artistName.toLowerCase().contains(searchTerm.toLowerCase())
                        || it.title.toLowerCase().contains(searchTerm.toLowerCase())
            }
        }

        return records
    }
}