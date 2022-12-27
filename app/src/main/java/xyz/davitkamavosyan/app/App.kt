package xyz.davitkamavosyan.app

import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module
import xyz.davitkamavosyan.app.data.local.database.AppDatabase
import xyz.davitkamavosyan.app.data.local.entity.EventEntity
import xyz.davitkamavosyan.app.data.remote.AuthInterceptor
import xyz.davitkamavosyan.app.data.remote.provideApi
import xyz.davitkamavosyan.app.data.remote.provideOkHttpClient
import xyz.davitkamavosyan.app.data.remote.provideRetrofit
import xyz.davitkamavosyan.app.datasource.remote.model.project.RemoteWeatherItem
import xyz.davitkamavosyan.app.domain.usecase.weather.GetWeatherUseCase
import xyz.davitkamavosyan.app.domain.mapper.EventMapper
import xyz.davitkamavosyan.app.domain.mapper.WeatherMapper
import xyz.davitkamavosyan.app.domain.model.Event
import xyz.davitkamavosyan.app.domain.model.Weather
import xyz.davitkamavosyan.app.domain.repository.EventRepository
import xyz.davitkamavosyan.app.domain.repository.WeatherRepository
import xyz.davitkamavosyan.app.domain.usecase.event.AddEventUseCase
import xyz.davitkamavosyan.app.domain.usecase.event.DeleteEventUseCase
import xyz.davitkamavosyan.app.domain.usecase.event.GetEventListUseCase
import xyz.davitkamavosyan.app.domain.usecase.event.GetEventUseCase
import xyz.davitkamavosyan.app.ui.navigation.NavigationViewModel
import xyz.davitkamavosyan.app.ui.screens.addevent.AddEventViewModel
import xyz.davitkamavosyan.app.ui.screens.event.EventDetailsViewModel
import xyz.davitkamavosyan.app.ui.screens.home.HomeViewModel

class App : Application() {

    private val databaseModul = module {
        single {
            Room.databaseBuilder(
                androidApplication(), AppDatabase::class.java, "AppDatabase"
            ).build()
        }
        single {
            val database = get<AppDatabase>()
            database.eventDao()
        }
    }

    private val remoteModule = module {
        factory { AuthInterceptor() }
        factory { provideOkHttpClient(get()) }
        factory { provideApi(get()) }
        single { provideRetrofit(get()) }
    }

    private val repoModule = module {
        single { WeatherRepository(get()) }
        single { EventRepository(get()) }
    }

    private val mapperModule = module {
        factory<(RemoteWeatherItem) -> Weather>(StringQualifier("weatherMapper")) { WeatherMapper() }
        factory<(EventEntity) -> Event>(StringQualifier("eventMapper")) { EventMapper() }
    }

    private val useCaseModule =
        module {
            factory { GetWeatherUseCase(get(), get(StringQualifier("weatherMapper"))) }
            factory { GetEventListUseCase(get(), get(StringQualifier("eventMapper"))) }
            factory { DeleteEventUseCase(get()) }
            factory { AddEventUseCase(get()) }
            factory { GetEventUseCase(get(), get(StringQualifier("eventMapper"))) }
        }

    private val androidModule = module {
        viewModel { NavigationViewModel(androidApplication()) }
        viewModel { HomeViewModel(androidApplication(), get(), get()) }
        viewModel { parameters ->
            AddEventViewModel(
                androidApplication(),
                get(),
                get(),
                get(),
                eventId = parameters.getOrNull()
            )
        }
        viewModel { parameters ->
            EventDetailsViewModel(
                androidApplication(),
                get(),
                get(),
                parameters.get()
            )
        }
    }

    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@App)
            modules(
                databaseModul,
                remoteModule,
                repoModule,
                mapperModule,
                useCaseModule,
                androidModule
            )
        }
    }
}