package com.magaliani.retrofit12feb;



import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by magaliani on 12/02/18.
 */

public interface PostInterfece {
    @POST("post")
    Call<Post> createNota(@Body Post post);
}
