package com.dyurekdeler.OnlineMovieStoreOrder.client

import com.dyurekdeler.OnlineMovieStoreInventory.request.DeliveryRequest
import com.dyurekdeler.OnlineMovieStoreOrder.model.Delivery
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PostMapping

@FeignClient("OnlineMovieStoreDelivery", url = "\${onlineMovieStore.delivery.url}")
interface DeliveryClient {

    @PostMapping("/deliveries/processDelivery")
    fun processDelivery(request: DeliveryRequest): Delivery
}