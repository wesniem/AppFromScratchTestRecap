package nyc.c4q.wesniemarcelin.appfromscratchtestrecap.recyclerView;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.wesniemarcelin.appfromscratchtestrecap.R;
import nyc.c4q.wesniemarcelin.appfromscratchtestrecap.model.Animal;

/**
 * Created by wesniemarcelin on 1/3/17.
 */

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    TextView animalName;
    private Animal animal;
    RecyclerView animalRecyclerView;


    public AnimalViewHolder(View itemView) {
        super(itemView);
        animalName = (TextView) itemView.findViewById(R.id.animal_name);
        animalRecyclerView = (RecyclerView)itemView.findViewById(R.id.animal_recyclerview);
    }

    public void bind(Animal animal) {
        this.animal = animal;
        String color = animal.getTextColor();
        animalName.setText(animal.getName());
        animalName.setTextColor(Color.parseColor(color));
    }
}
