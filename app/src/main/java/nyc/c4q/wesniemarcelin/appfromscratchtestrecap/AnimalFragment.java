package nyc.c4q.wesniemarcelin.appfromscratchtestrecap;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.List;

import nyc.c4q.wesniemarcelin.appfromscratchtestrecap.model.Animal;
import nyc.c4q.wesniemarcelin.appfromscratchtestrecap.model.AnimalList;
import nyc.c4q.wesniemarcelin.appfromscratchtestrecap.network.AnimalService;
import nyc.c4q.wesniemarcelin.appfromscratchtestrecap.recyclerView.AnimalAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wesniemarcelin on 1/3/17.
 */

public class AnimalFragment extends Fragment {
    private static final String BASE_URL = "http://jsjrobotics.nyc/cgi-bin/";
    private static final String TAG = "YOOOO";
    RecyclerView animalRecyclerView;
    List<Animal> mAnimals;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mroot = inflater.inflate(R.layout.animal_fragment, container, false);
        animalRecyclerView = (RecyclerView) mroot.findViewById(R.id.animal_recyclerview);
        animalRetrofitCall();
        return mroot;
    }

    public void animalRetrofitCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimalService service = retrofit.create(AnimalService.class);
        Call<AnimalList> call = service.getAnimals();

        call.enqueue(new Callback<AnimalList>() {
            @Override
            public void onResponse(Call<AnimalList> call, Response<AnimalList> response) {
                if (response.isSuccessful()) {
                    Log.d("Sucess", "Successfull Response");

                    //Tasks to be completed on successful response from Call
                    AnimalList animalResponse = response.body();
                    mAnimals = animalResponse.getAnimals();

                    //Logging for successful response
                    Log.d("POJOs", mAnimals.get(0).getBackground());

                    //Set up recyclerView with adapters
                    animalRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    AnimalAdapter adapter = new AnimalAdapter(mAnimals);
                    animalRecyclerView.setAdapter(adapter);

                    Log.d("Adapter", "Adapter attached");

                } else {
                    try {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<AnimalList> call, Throwable t) {
                Log.d(TAG, "Failure" + t.getMessage());
            }
        });

    }

}
