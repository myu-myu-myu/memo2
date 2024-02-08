package com.example.backend_kotlin2

interface MemoService {
    fun getMemos ():List<Memo>
}
class MemoServiceImpl(val repository:MemoRepository): MemoService{
    override fun getMemos(): List<Memo> {
        repository.findAll()
        return listOf(Memo())
    }

}



