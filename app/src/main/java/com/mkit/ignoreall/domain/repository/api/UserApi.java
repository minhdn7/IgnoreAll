package com.mkit.ignoreall.domain.repository.api;


import com.sieutroll.domain.repository.ServiceUrl;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface UserApi {
    @GET(ServiceUrl.ChECK_SERVICE)
    Observable<Response<String>> checkService(@Query("appgamecode") String appgamecode,
                                              @Query("os") Integer os,
                                              @Query("deviceid") String deviceid,
                                              @Query("auth") String auth,
                                              @Query("country") String country
                                              );

}
