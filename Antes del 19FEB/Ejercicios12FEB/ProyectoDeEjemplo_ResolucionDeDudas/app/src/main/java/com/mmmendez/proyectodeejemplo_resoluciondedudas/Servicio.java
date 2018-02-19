package com.mmmendez.proyectodeejemplo_resoluciondedudas;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mmmendez on 13/02/2018.
 */

public class Servicio {
    private static final String BASE_URL = "https://api.openweathermap.org";



//desde aqui
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();//hasta aqui construimos el objeto retrofit



//creamos el interceptor(filtro) Escribeme las peticiones y respuestas en el log
//Los interceptores se definen a nivel de okhttp.
    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);//nivel de loggin, con body se muestra todo.

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();




//Aquí pasamos la interfaz con la que vamos a crear el interceptor y lo añade a retrofit para crear
// el servicio
    public static <S> S createService(
            Class<S> serviceClass) {
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging);
            /*A Partir de aquí creamos un interceptor que va a llevar los headers (Pares clave-valor)
            de la aplicación*/
            httpClient.addInterceptor((new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    HttpUrl originalHttpUrl = original.url();

                    HttpUrl url = originalHttpUrl.newBuilder()
                            .addQueryParameter("APPID", "ed8e041a3c5a3c61424cc4b0e11bbd41")
                            .addQueryParameter("units","numeric")
                            .addQueryParameter("Lang", "es")
                            .build();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            .url(url);

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            }));
            builder.client(httpClient.build());
            retrofit = builder.build();
        }

        return retrofit.create(serviceClass);
    }
}
