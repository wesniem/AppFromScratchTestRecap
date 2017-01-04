package nyc.c4q.wesniemarcelin.appfromscratchtestrecap.model;

/**
 * Created by wesniemarcelin on 1/3/17.
 */

import com.google.gson.annotations.SerializedName;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnimalList {

    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("animals")
    @Expose
    private List<Animal> animals = null;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

}

