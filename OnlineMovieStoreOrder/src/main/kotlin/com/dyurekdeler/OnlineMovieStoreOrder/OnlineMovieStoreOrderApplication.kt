package com.dyurekdeler.OnlineMovieStoreOrder

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
class OnlineMovieStoreOrderApplication

fun main(args: Array<String>) {
	runApplication<OnlineMovieStoreOrderApplication>(*args)
}
