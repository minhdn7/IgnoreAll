package com.mkit.ignoreall.app.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.mkit.ignoreall.domain.interactor.UserInteractor;
import com.mkit.ignoreall.domain.interactor.UserInteractorImpl;
import com.mkit.ignoreall.domain.repository.api.UserApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MinhDN on 5/2/2018.
 */
@Module(complete = false, library = true)
public class UserModule {
    @Provides
    UserApi provideIService(Retrofit.Builder retrofitBuilder) {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit =
                retrofitBuilder.addConverterFactory(GsonConverterFactory.create(gson)).build();

        return retrofit.create(UserApi.class);
    }

    @Provides
    UserInteractor provideUserInteractor(UserInteractorImpl userInteractor) {
        return userInteractor;
    }


}
