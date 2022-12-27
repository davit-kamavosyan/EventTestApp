package xyz.davitkamavosyan.app.datasource.remote

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

suspend fun <T> safeApiCall(dispatcher: CoroutineDispatcher, apiCall: suspend () -> T): Flow<T> {
    return withContext(dispatcher) {
        flow { emit(apiCall.invoke()) }.catch {
            throw Exception("An error occurred")
        }
    }
}
