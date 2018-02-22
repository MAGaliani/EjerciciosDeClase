package com.magaliani.keepgaliani;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by GaloMcTunki on 21/02/2018.
 */

public interface ILoginAndRegister {

    @FormUrlEncoded
    @POST("/keeper/api/auth/login")
    Call<ResponseAuth> doLogin(@Field("email") String email,
                               @Field("password") String password);

    @FormUrlEncoded
    @POST("/keeper/api/auth/register")
    Call<ResponseAuth> doRegistro(@Field("nombre") String nombre,
                                  @Field("email") String email,
                                  @Field("password") String password);
}
