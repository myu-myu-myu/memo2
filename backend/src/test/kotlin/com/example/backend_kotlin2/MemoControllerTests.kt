package com.example.backend_kotlin2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class MemoControllerTests {
    private lateinit var controller: MemoController
    private lateinit var mockMvc : MockMvc

    val memoService = MemoServiceTestDouble()

    @BeforeEach
    fun setup(){
        controller = MemoController(memoService)
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build()

    }

    @Test
    fun `it should return status code 200`(){
        mockMvc.perform(
            get("/api/v1/data")
        )
            .andExpect(status().isOk)
    }

    @Test
    fun `it should call MemoService`(){
        //given arrange


        //when act　
        mockMvc.perform(
            get("/api/v1/data")
        )

        //then
        assertThat(memoService.getMemos_isCalled).isTrue()
    }
    @Test
    fun `it should return list of Memo`(){
        //given arrange
        memoService.getMemos_return_value=listOf(Memo(
            id =1,
            user_id =2,
            create_date =100,
            update_date =200,
            content ="これはテストダブルです"
        ))

        //when act　
        mockMvc.perform(
            get("/api/v1/data")
        )

        //then
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].user_id").value(2))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].create_date").value(100))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].update_date").value(200))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].content").value("これはテストダブルです"))
    }
}