package com.amazinghorsess.utils

sealed class OrderType {
    object Ascending : OrderType()
    object Descending: OrderType()

}