package nyc.c4q.wesniemarcelin.appfromscratchtestrecap;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.wesniemarcelin.appfromscratchtestrecap.model.AnimalList;
import nyc.c4q.wesniemarcelin.appfromscratchtestrecap.network.AnimalService;
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
    RecyclerView animalRecyclerView;

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

            }

            @Override
            public void onFailure(Call<AnimalList> call, Throwable t) {

            }
        });

    }

}
