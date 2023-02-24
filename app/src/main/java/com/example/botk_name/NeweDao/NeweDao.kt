package com.example.botk_name.NeweDao

import androidx.room.*
import com.example.botk_name.News


@Dao
interface NeweDao {
    @Query("select * from news where typeNews = :type")
    fun getAllNews(type: String): List<News>

    @Insert
    fun addNews(news: News)

    @Delete
    fun deleteNews(news: News)

    @Update
    fun update(news: News)

    @Query("select * from news where id=:id")
    fun getNewsById(id: Int): News

    @Insert
    fun addAllNews(vararg users: News)
}