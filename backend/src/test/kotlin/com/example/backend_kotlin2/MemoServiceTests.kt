package com.example.backend_kotlin2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested

class MemoServiceTests {
    private lateinit var service: MemoService
    private var repository = MemoRepositoryTestDouble()

    @BeforeEach
    fun setup(){
        service = MemoServiceImpl(repository)
    }

    @Nested
    inner class `getMemosTests for service` {
        @Test
        fun `it should call repository`(){
            //when
            service.getMemos()

            //then
            Assertions.assertThat(repository.findAll_isCalled).isTrue()
        }
        @Test
        fun `it should return list of Memo`(){
            //given
            repository.findAll_returnValue = mutableListOf(MemoEntity(
                id = 2,
                user_id = 3,
                create_date = 299,
                update_date = 300,
                content = "repositoryからの返り値"
            ))

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

    @Nested
    inner class `postMemoTests for service` {
        @Test
        fun `it should call repository_save`(){
            //when
            service.postMemo(Memo())

            //then
            Assertions.assertThat(repository.save_isCalled).isTrue()
        }
        @Test
        fun `it should return Memo`(){
            //given
            repository.save_returnValue = MemoEntity(
                id = 20,
                user_id = 30,
                create_date = 2990,
                update_date = 3000,
                content = "repositoryからの返り値2"
            )

            //when
            val res = service.postMemo(Memo())

            //then
            assertEquals(Memo(
                id = 20,
                user_id = 30,
                create_date = 2990,
                update_date = 3000,
                content = "repositoryからの返り値2"
            ), res)
        }
        @Test
        fun `it should call with correct argument`(){
            //given
            val testArg = Memo(
                id = 20,
                user_id = 30,
                create_date = 2990,
                update_date = 3000,
                content = "repositoryからの返り値2"
            )

            //when
            service.postMemo(testArg)

            //then
            assertEquals(MemoEntity(
                id = testArg.id,
                user_id = testArg.user_id,
                create_date = testArg.create_date,
                update_date = testArg.update_date,
                content = testArg.content
            ), repository.save_argument)
        }
    }
}