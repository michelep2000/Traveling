package es.travelworld.traveling;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import es.travelworld.traveling.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    static ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*PageAdapterOnboarding adapterOnboarding = new PageAdapterOnboarding(this);
        binding.viewPager.setAdapter(adapterOnboarding);

        viewPager = binding.viewPager;*/ //TODO: Uncomment
    }

    public static void next (){
        System.out.println("NEXT");
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
    }

    /*public static void prev (){
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }*/

}