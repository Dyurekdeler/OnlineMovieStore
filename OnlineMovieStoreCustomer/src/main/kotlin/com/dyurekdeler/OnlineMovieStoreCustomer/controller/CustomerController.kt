package com.dyurekdeler.OnlineMovieStoreCustomer.controller

import com.dyurekdeler.OnlineMovieStoreCustomer.entity.Customer
import com.dyurekdeler.OnlineMovieStoreCustomer.repository.CustomerRepository
import com.dyurekdeler.OnlineMovieStoreCustomer.request.CustomerRequest
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
class CustomerController(
    private val customerRepository: CustomerRepository
) {

    @GetMapping()
    fun getAllCustomers(): ResponseEntity<List<Customer>> {
        val customers = customerRepository.findAll()
        return ResponseEntity.ok(customers)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable("id") id: String): Customer {
        val customer = customerRepository.findOneById(ObjectId(id))
        return customer
    }

    @PostMapping
    fun createCustomer(@RequestBody request: CustomerRequest): ResponseEntity<Customer> {
        val customer = customerRepository.save(Customer(
            firstname = request.firstname,
            lastname = request.lastname,
            address = request.address,
            phone = request.phone,
        ))
        return ResponseEntity(customer, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable("id") id: String, @RequestBody request: CustomerRequest, ): ResponseEntity<Customer> {
        val customer = customerRepository.findOneById(ObjectId(id))
        val updatedCustomer = customerRepository.save(
            Customer(
                id = customer.id,
                firstname = request.firstname,
                lastname = request.lastname,
                address = request.address,
                phone = request.phone,
                createdDate = customer.createdDate,
                modifiedDate = LocalDateTime.now()
            )
        )
        return ResponseEntity.ok(updatedCustomer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable("id") id: String): ResponseEntity<Unit> {
        customerRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}