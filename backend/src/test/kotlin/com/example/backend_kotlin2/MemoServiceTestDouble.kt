package com.example.backend_kotlin2

class MemoServiceTestDouble:MemoService {
    var getMemos_isCalled = false

    var getMemos_return_value = listOf(Memo())

    override fun getMemos(): List<Memo> {
        getMemos_isCalled = true
        return getMemos_return_value
    }
}