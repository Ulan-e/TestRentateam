package com.ulanapp.mvvm.project.di

import com.ulanapp.mvvm.project.ui.details.DetailsFragment
import com.ulanapp.mvvm.project.ui.home.HomeFragment
import com.ulanapp.mvvm.project.ui.about.AboutFragment
import com.ulanapp.mvvm.project.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector()
    abstract fun mainActivity(): MainActivity
}

@Module(includes = arrayOf(RepositoryModule::class))
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector()
    abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector()
    abstract fun infoFragment(): AboutFragment

    @ContributesAndroidInjector()
    abstract fun detailsFragment(): DetailsFragment
}