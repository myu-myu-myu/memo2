package com.example.backend_kotlin2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MemoServiceTests {
    private lateinit var service: MemoService
    private var repository = MemoRepositoryTestDouble()

    @Test
    fun `it should call repository`(){
        //given
        service = MemoServiceImpl(repository)

        //when
        service.getMemos()

        //then
        Assertions.assertThat(repository.findAll_isCalled).isTrue()
    }
    @Test
    fun `it should return list of Memo`(){
        //given
        service = MemoServiceImpl(repository)

        //when
        val res = service.getMemos()

        //then
        assertEquals(res[0].id,2)
        assertEquals(res[0].user_id,3)
        assertEquals(res[0].create_date,299)
        assertEquals(res[0].update_date,300)
        assertEquals(res[0].content,"repositoryからの返り値")
    }
}