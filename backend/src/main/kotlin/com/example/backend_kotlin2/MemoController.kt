package com.example.backend_kotlin2
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class MemoController (val memoService: MemoService) {

    @GetMapping("/v1/data")
    fun getMemo():List<Memo>{
        return memoService.getMemos()
    }
}