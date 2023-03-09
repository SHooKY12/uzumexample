package com.example.exampleuzum

import dataclassesForUse.ProductList
import retrofit2.http.GET

interface RetrofitApi {
       @GET("products")
      suspend fun getAllProducts(): ProductList
}