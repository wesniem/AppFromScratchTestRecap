package nyc.c4q.wesniemarcelin.appfromscratchtestrecap.recyclerView;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.wesniemarcelin.appfromscratchtestrecap.AnimalFragment;
import nyc.c4q.wesniemarcelin.appfromscratchtestrecap.R;
import nyc.c4q.wesniemarcelin.appfromscratchtestrecap.model.Animal;

/**
 * Created by wesniemarcelin on 1/3/17.
 */

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    TextView animalName;
    private Animal animal;
    private View mRoot;
    RecyclerView animalRecyclerView;


    public AnimalViewHolder(View itemView) {
        super(itemView);
        mRoot = itemView;
        animalName = (TextView) itemView.findViewById(R.id.animal_name);
        animalRecyclerView = (RecyclerView)itemView.findViewById(R.id.animal_recyclerview);
    }

    public void bind(final Animal animal) {
        this.animal = animal;
        String color = animal.getTextColor();
        final int backgroundColor= Color.parseColor(animal.getBackground());
        animalName.setText(animal.getName());
        animalName.setTextColor(Color.parseColor(color));

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRoot.getRootView().setBackgroundColor(backgroundColor);
            }
        });
    }
}
