package nyc.c4q.wesniemarcelin.appfromscratchtestrecap.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.wesniemarcelin.appfromscratchtestrecap.R;
import nyc.c4q.wesniemarcelin.appfromscratchtestrecap.model.Animal;
import nyc.c4q.wesniemarcelin.appfromscratchtestrecap.model.AnimalList;

/**
 * Created by wesniemarcelin on 1/3/17.
 */

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    public List<Animal> mAnimalLists;

    public AnimalAdapter(List<Animal> animalLists) {
        this.mAnimalLists = animalLists;
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Passes in specific view of animal item to each new viewholder
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item_layout, parent, false);
        return new AnimalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mAnimalLists.size();
    }
}
