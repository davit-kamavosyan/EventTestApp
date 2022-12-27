package xyz.davitkamavosyan.app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.settlo.inventories.data.local.converter.Converters
import xyz.davitkamavosyan.app.data.local.dao.EventDao
import xyz.davitkamavosyan.app.data.local.entity.EventEntity

@Database(
    entities = [
        EventEntity::class,
    ], version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
}