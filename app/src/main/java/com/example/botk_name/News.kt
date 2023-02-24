package com.example.botk_name

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class News(
    var name: String,
    var info: String,
    var typeNews: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
) : java.io.Serializable