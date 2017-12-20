package nl.wykorijnsburger.recordstores.anyoldtime

import org.assertj.core.api.Assertions.*
import org.junit.Test

class AnyOldTimeTxtParserTest {

    @Test
    fun `Test parser`() {
        val result = javaClass.classLoader.getResource("anyoldtime_test.txt")
                .openStream()
                .parse()

        val first = result.first()
        assertThat(first.artistName).isEqualTo("10 CC")
        assertThat(first.title).isEqualTo("100 CC greatest hits")
        assertThat(first.format).isEqualTo(RecordFormat.LP)
        assertThat(first.label).isEqualTo("Decca")
        assertThat(first.country).isEqualTo("NL")
        assertThat(first.releaseNumber).isEqualTo("6376 115")
        assertThat(first.releaseYear).isEqualTo("-'75")
        assertThat(first.condition).isEqualTo(RecordCondition.F)
        assertThat(first.priceInEuro).isEqualTo("3,00")
        assertThat(first.classification).isEqualTo("70s")

        val last = result.last()
        assertThat(last.artistName).isEqualTo("MIKE AULDRIDGE")
        assertThat(last.title).isEqualTo("Dobre")
        assertThat(last.format).isEqualTo(RecordFormat.LP)
        assertThat(last.label).isEqualTo("Sonet")
        assertThat(last.country).isEqualTo("E")
        assertThat(last.releaseNumber).isEqualTo("SNTF 657")
        assertThat(last.releaseYear).isEqualTo("-'74")
        assertThat(last.condition).isEqualTo(RecordCondition.V)
        assertThat(last.priceInEuro).isEqualTo("7,00")
        assertThat(last.classification).isEqualTo("Country/Bluegrass")
    }
}