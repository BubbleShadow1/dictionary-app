package com.androidapp.dictionary;

import android.content.Context;
import android.widget.Toast;

import com.androidapp.dictionary.Model.APIResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;


public class RequestManager {
    Context context;
    Retrofit retrofitt=new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .build();




    public RequestManager(Context context) {
        this.context = context;
    }

    public void getWordMeaning(onFetchdatalistener listener,String word)
    {
        CallDictionary callDictionary=retrofitt.create(CallDictionary.class);
        Call<List<APIResponse>> call=callDictionary.callMeanings(word);
        try
        {
            call.enqueue(new Callback<List<APIResponse>>() {
                @Override
                public void onResponse(Call<List<APIResponse>> call, Response<List<APIResponse>> response) {
                    if(!response.isSuccessful())
                    {
                        Toast.makeText(context, "Error!!!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    listener.onFetchData(response.body().get(0),response.message());
                }

                @Override
                public void onFailure(Call<List<APIResponse>> call, Throwable t) {
listener.onerror("Request Failed!!!");
                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(context, "An error Occured", Toast.LENGTH_SHORT).show();
        }

    }
    public interface CallDictionary{
        @GET("entries/en/{word}")
        Call<List<APIResponse>> callMeanings(  @Path("word")String word);

    }
}
