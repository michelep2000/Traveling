package es.travelworld.traveling.home.homeTabZero;


import android.graphics.Paint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import es.travelworld.traveling.R;
import es.travelworld.traveling.models.Address;
import es.travelworld.traveling.models.Hotel;
import es.travelworld.traveling.models.OptimizedThumbUrls;
import es.travelworld.traveling.models.Price;
import es.travelworld.traveling.models.RatePlan;

public class ListAdapterHomeTabZero extends RecyclerView.Adapter<ListAdapterHomeTabZero.ViewHolderTabZero> {

    private List<Hotel> hotels;

    public ListAdapterHomeTabZero(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @NonNull
    @Override
    public ListAdapterHomeTabZero.ViewHolderTabZero onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item, parent, false);
        return new ListAdapterHomeTabZero.ViewHolderTabZero(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterHomeTabZero.ViewHolderTabZero holder, int position) {
        holder.bindData(hotels.get(position));
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public void setItems(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public static class ViewHolderTabZero extends RecyclerView.ViewHolder implements View.OnClickListener {
        ShapeableImageView image;
        MaterialTextView nameLabel, priceLabel, oldPriceLabel, ratingLabel, addressLabel, localityLabel;


        public ViewHolderTabZero(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            image = itemView.findViewById(R.id.hotelImg);
            nameLabel = itemView.findViewById(R.id.hotelName);
            priceLabel = itemView.findViewById(R.id.hotelPrice);
            oldPriceLabel = itemView.findViewById(R.id.hotelOldPrice);
            ratingLabel = itemView.findViewById(R.id.hotelRating);
            addressLabel = itemView.findViewById(R.id.hotelAddress);
            localityLabel = itemView.findViewById(R.id.hotelLocality);

        }

        void bindData(final Hotel hotel) {

            OptimizedThumbUrls url = hotel.getOptimizedThumbUrls();
            RatePlan ratePlan = hotel.getRatePlan();
            Price price = ratePlan.getPrice();
            Address address = hotel.getAddress();

            Glide.with(this.itemView).load(url.getSrpDesktop()).into(image);
            nameLabel.setText(hotel.getName());
            priceLabel.setText(price.getCurrent());
            oldPriceLabel.setText(price.getOld());
            ratingLabel.setText(String.valueOf(hotel.getStarRating()));
            addressLabel.setText(address.getStreetAddress());
            localityLabel.setText(address.getLocality());

            oldPriceLabel.setPaintFlags(oldPriceLabel.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        }

        @Override
        public void onClick(View view) {
            final MaterialTextView name = view.findViewById(R.id.hotelName);
            Toast.makeText(view.getContext(), name.getText(), Toast.LENGTH_SHORT).show();
        }

    }

}
