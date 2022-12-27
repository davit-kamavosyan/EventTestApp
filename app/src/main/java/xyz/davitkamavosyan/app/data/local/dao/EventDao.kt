package xyz.davitkamavosyan.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import xyz.davitkamavosyan.app.data.local.entity.EventEntity

@Dao
interface EventDao {

    @Query("SELECT * FROM `event`")
    fun getEventList(): Flow<List<EventEntity>>

    @Query("SELECT * FROM `event` where id =:id")
    fun getEventById(id: Long): Flow<EventEntity>

    @Query("DELETE FROM `event` WHERE id =:id")
    fun deleteEventById(id: Long)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg event: EventEntity)
}
