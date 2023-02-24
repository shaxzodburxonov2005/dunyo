package com.example.botk_name

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.botk_name.NeweDao.NeweDao

@Database(entities = [News::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun newsDao():NeweDao

    companion object{
        private var instance:AppDatabase?=null

        @Synchronized
        fun getInstance(context:Context):AppDatabase{
            if (instance==null){
                instance=Room.databaseBuilder(context,AppDatabase::class.java,"news.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance !!
        }
    }


}