package com.mkit.ignoreall.app.di;

import android.content.Context;


import com.mkit.ignoreall.app.LineApplication;

import com.mkit.ignoreall.ui.activity.BaseActivity;
import com.mkit.ignoreall.ui.activity.HomeActivity;
import com.mkit.ignoreall.ui.activity.MoreAppActivity;
import com.mkit.ignoreall.ui.activity.StartActivity;
import com.mkit.ignoreall.ui.fragment.BaseFragment;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
/**
 * Created by LiKaLi on 1/22/2018.
 */
@Module(
        includes = {

                UserModule.class,
                NetModule.class
        },
        injects = {
                //App
                LineApplication.class,

                // - view
                BaseActivity.class,
                BaseFragment.class,
                HomeActivity.class,
                MoreAppActivity.class,
                StartActivity.class
                //Activity

//        //Fragment

//        ThongBaoFragment.class
        }, library = true)
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

//    @Provides @Singleton public Context provideApplicationContext() {
//        return this.context;
//    }
}
