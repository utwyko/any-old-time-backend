package nl.wykorijnsburger.recordstores.anyoldtime

import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.InputStreamResource
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import java.io.InputStream

@Component
class AnyOldTimeClient {

    val webclient = WebClient.builder()
            .baseUrl("http://www.anyoldtime.nl")
            .build()

    internal fun getLPs() =
            webclient.get()
                    .uri("/voorraad/anyoldtime_WWW-LP.txt")
                    .exchange()
                    .flatMap { it.bodyToMono(ByteArrayResource::class.java) }
                    .map { it.byteArray.inputStream() };
}