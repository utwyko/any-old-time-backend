package nl.wykorijnsburger.recordstores.anyoldtime

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/recordstore/anyoldtime"])
class AnyOldTimeController(val anyOldTimeService: AnyOldTimeService) {

    @CrossOrigin
    @GetMapping("/records")
    fun getRecords(@RequestParam("q") searchTerm: String?) = anyOldTimeService.searchRecords(searchTerm)
            .map { it.toResponse() }
            .take(20)

}

private fun Record.toResponse() = RecordResponse(
        artistName = artistName,
        title = title,
        condition = condition.displayName,
        priceInEuro = priceInEuro
)

data class RecordResponse(
        val artistName: String,
        val title: String,
        val condition: String,
        val priceInEuro: String
)
