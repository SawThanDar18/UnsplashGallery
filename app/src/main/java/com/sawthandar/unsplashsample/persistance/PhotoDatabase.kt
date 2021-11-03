package com.sawthandar.unsplashsample.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sawthandar.unsplashsample.data.vos.PhotoVO
import com.sawthandar.unsplashsample.persistance.daos.PhotoDao
import com.sawthandar.unsplashsample.utils.DB_NAME

@Database(entities = [PhotoVO::class], exportSchema = false, version = 9)
abstract class PhotoDatabase: RoomDatabase() {

    abstract fun photoDao(): PhotoDao

    companion object {
        private var instance: PhotoDatabase? = null

        fun getInstance(context: Context): PhotoDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, PhotoDatabase::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return instance!!
        }
    }
}