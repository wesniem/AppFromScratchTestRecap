package nyc.c4q.wesniemarcelin.appfromscratchtestrecap.network;

import nyc.c4q.wesniemarcelin.appfromscratchtestrecap.model.AnimalList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by wesniemarcelin on 1/3/17.
 */
//Interface always has the top level object ie => the AnimalList
public interface AnimalService {
    @GET("")
    Call<AnimalList> getAnimals();
}
