package com.example.myapplication.Datos;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Adapter.ListaFragmentsAdapter;
import com.example.myapplication.Adapter.ViewPagerFragmetsAdapter;
import com.example.myapplication.Fragments.FragmentDescubrir;
import com.example.myapplication.Fragments.FragmentFav;
import com.example.myapplication.Fragments.FragmentPerfil;
import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;

public class ContenedorFragments extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        tabLayout = findViewById(R.id.tableLayout);
        viewPager = findViewById(R.id.viewPager);

        //añadir fragment
        ViewPagerFragmetsAdapter adaptadorVP = new ViewPagerFragmetsAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        //ViewPagerAdapter.ViewPagerFragmentsAdapter adaptadorVP = new ViewPagerAdapter.ViewPagerFragmentsAdapter(getSupportFragmentManager());
        adaptadorVP.addFragment(new FragmentDescubrir(), "Descubrir");
        adaptadorVP.addFragment(new FragmentFav(), "Favoritos");
        adaptadorVP.addFragment(new FragmentPerfil(), "Perfil");

        viewPager.setAdapter(adaptadorVP);
        //viewPager.setOffscreenPageLimit(3);

//        // Attach the page change listener inside the activity
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//            // This method will be invoked when a new page becomes selected.
//            @Override
//            public void onPageSelected(int position) {
//                if (viewPager != null) {
//                    ViewPagerAdapter fragment = (ViewPagerAdapter)viewPager.getCurrentItem(position);
//                    if (fragment != null) {
//                        fragment.update();
//                    }
//                }
//            }
//
//            // This method will be invoked when the current page is scrolled
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                // Code goes here
//            }
//
//            // Called when the scroll state changes:
//            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                // Code goes here
//            }
//        });

        tabLayout.setupWithViewPager(viewPager);

        //iconos de las celdas
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_account_perfil);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_favorite);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_search);

        ListaFragmentsAdapter.llenarLista();

    }
}
