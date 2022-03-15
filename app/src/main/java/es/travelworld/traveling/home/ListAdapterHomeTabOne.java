package es.travelworld.traveling.home;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import es.travelworld.traveling.R;
import es.travelworld.traveling.models.CarItem;

public class ListAdapterHomeTabOne extends RecyclerView.Adapter<ListAdapterHomeTabOne.ViewHolder> {

    private List<CarItem> cars;

    public ListAdapterHomeTabOne(List<CarItem> cars) {
        this.cars = cars;
    }

    @NonNull
    @Override
    public ListAdapterHomeTabOne.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterHomeTabOne.ViewHolder holder, int position) {
        holder.bindData(cars.get(position));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public void setItems(List<CarItem> cars) {
        this.cars = cars;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ShapeableImageView image;
        MaterialTextView name, price;
        ConstraintLayout constraintLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            constraintLayout = itemView.findViewById(R.id.listCarLayout);
            image = itemView.findViewById(R.id.listCarImage);
            name = itemView.findViewById(R.id.listCarName);
            price = itemView.findViewById(R.id.listCarPrice);
        }

        void bindData(final CarItem car) {
            image.setImageResource(car.getImage());
            name.setText(car.getName());
            price.setText(car.getPrice());

            Drawable layoutBackground = constraintLayout.getBackground();
            layoutBackground = DrawableCompat.wrap(layoutBackground);
            DrawableCompat.setTint(layoutBackground, Color.parseColor(car.color));
            constraintLayout.setBackground(layoutBackground);
        }

        @Override
        public void onClick(View view) {
            System.out.println("ON CLICK::::");
            final MaterialTextView name = view.findViewById(R.id.listCarName);
            Toast.makeText(view.getContext(), name.getText(), Toast.LENGTH_SHORT).show();
        }

    }

}
