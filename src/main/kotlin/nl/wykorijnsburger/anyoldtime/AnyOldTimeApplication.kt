package nl.wykorijnsburger.anyoldtime

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class RecordstoresApplication

fun main(args: Array<String>) {
    SpringApplication.run(RecordstoresApplication::class.java, *args)
}
