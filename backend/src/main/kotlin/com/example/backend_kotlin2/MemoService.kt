package com.example.backend_kotlin2

interface MemoService {
    fun getMemos ():List<Memo>
    fun postMemo (memo:Memo):Memo
}
class MemoServiceImpl(val repository:MemoRepository): MemoService{
    override fun getMemos(): List<Memo> {
        return repository.findAll().map{
            Memo(
                it.id,
                it.user_id,
                it.create_date,
                it.update_date,
                it.content
            )
        }
    }

    override fun postMemo(memo:Memo):Memo {
        val res = repository.save(
            MemoEntity(
                id = memo.id,
                user_id = memo.user_id,
                create_date = memo.create_date,
                update_date = memo.update_date,
                content = memo.content
            )
        )
        return Memo(
            id = res.id,
            user_id = res.user_id,
            create_date = res.create_date,
            update_date = res.update_date,
            content = res.content
        )
    }
}



