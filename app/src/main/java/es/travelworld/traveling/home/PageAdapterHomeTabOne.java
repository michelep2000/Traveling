package es.travelworld.traveling.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import es.travelworld.traveling.R;
import es.travelworld.traveling.models.CarItem;

public class PageAdapterHomeTabOne extends RecyclerView.Adapter<PageAdapterHomeTabOne.ViewHolder> {

    private List<CarItem> cars;
    private LayoutInflater inflater;
    private Context context;

    public PageAdapterHomeTabOne(List<CarItem> cars, Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.cars = cars;
    }

    @NonNull
    @Override
    public PageAdapterHomeTabOne.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.car_item, null);
        return new PageAdapterHomeTabOne.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PageAdapterHomeTabOne.ViewHolder holder, int position) {
        holder.bindData(cars.get(position));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public void setItems(List<CarItem> cars) {
        this.cars = cars;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView image;
        MaterialTextView name, price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.listCarImage);
            name = itemView.findViewById(R.id.listCarName);
            price = itemView.findViewById(R.id.listCarPrice);
        }

        void bindData(final CarItem car) {
            image.setImageResource(car.getImage());
            name.setText(car.getName());
            price.setText(car.getPrice());
        }

    }

}
