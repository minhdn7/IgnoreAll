package com.mkit.ignoreall.domain.interactor;


import retrofit2.Response;
import rx.Observable;

/**
 * Created by MinhDN on 7/5/2018.
 */
public interface UserInteractor {
    Observable<Response<String>> checkService(String appgamecode, Integer os, String deviceid, String auth, String country);
}
