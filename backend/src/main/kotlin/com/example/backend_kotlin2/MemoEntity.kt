package com.example.backend_kotlin2

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name="MemoEntity")
data class MemoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_seq", sequenceName = "", allocationSize = 1)
    val id: Int,
    val user_id: Int = 0,
    val create_date: Int = 0,
    val update_date: Int = 0,
    val content: String = ""
)
