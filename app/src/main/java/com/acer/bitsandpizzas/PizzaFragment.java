package com.acer.bitsandpizzas;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PizzaFragment extends Fragment {


    public PizzaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_pizza,
                container,
                false
        );

        int pizzaCount = Pizza.pizzas.length;

        String[] pizzaNames = new String[pizzaCount];
        for (int i = 0; i < pizzaCount; i++) {
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }

        int[] pizzaImages = new int[pizzaCount];
        for (int i = 0; i < pizzaCount; i++) {
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        }

        final CaptionedImagesAdapter captionedImagesAdapter = new CaptionedImagesAdapter(pizzaNames, pizzaImages);

        pizzaRecycler.setAdapter(captionedImagesAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);

        pizzaRecycler.setLayoutManager(layoutManager);

        captionedImagesAdapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return pizzaRecycler;
    }

}
