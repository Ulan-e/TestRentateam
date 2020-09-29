package com.ulanapp.testrentateam.project.di

import com.ulanapp.testrentateam.project.ui.details.DetailsFragment
import com.ulanapp.testrentateam.project.ui.home.HomeFragment
import com.ulanapp.testrentateam.project.ui.info.InfoFragment
import com.ulanapp.testrentateam.project.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module()
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector()
    abstract fun mainActivity(): MainActivity
}

@Module(includes = arrayOf(RepositoryModule::class))
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector()
    abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector()
    abstract fun infoFragment(): InfoFragment

    @ContributesAndroidInjector()
    abstract fun detailsFragment(): DetailsFragment

}