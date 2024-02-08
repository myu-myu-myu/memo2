package com.example.backend_kotlin2

class MemoServiceTestDouble:MemoService {
    var getMemos_isCalled = false
    var getMemos_return_value = listOf(Memo())
    var postMemo_isCalled = false
    var postMemo_return_value = Memo()
    var postMemo_argument = Memo()

    override fun getMemos(): List<Memo> {
        getMemos_isCalled = true
        return getMemos_return_value
    }

    override fun postMemo(memo:Memo):Memo {
        postMemo_isCalled = true
        postMemo_argument = memo
        return postMemo_return_value
    }
}