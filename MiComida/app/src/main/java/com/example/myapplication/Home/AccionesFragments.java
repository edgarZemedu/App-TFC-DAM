package com.example.myapplication.Home;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Fragments.FragmentDescubrir;
import com.example.myapplication.Fragments.FragmentFav;
import com.example.myapplication.Fragments.FragmentPerfil;
import com.example.myapplication.Interfaz.InterfazFragments;
import com.example.myapplication.R;
import com.example.myapplication.Adapter.ViewPagerFragmetsAdapter;
import com.google.android.material.tabs.TabLayout;

public class AccionesFragments extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    Button botonFavoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        tabLayout = findViewById(R.id.tableLayout);
        viewPager = findViewById(R.id.viewPager);

        //añadir fragment
        ViewPagerFragmetsAdapter viewPagerAdapter = new ViewPagerFragmetsAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragment(new FragmentDescubrir(),"Descubrir");
        viewPagerAdapter.addFragment(new FragmentFav(),"Favoritos");
        viewPagerAdapter.addFragment(new FragmentPerfil(),"Perfil");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //iconos de las celdas
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_account_perfil);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_favorite);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_search);
/*
        botonFavoritos = vista.findViewById(R.id.buttonFavoritos);

        botonFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("productoFav",listaProductos.get(.getChildAdapterPosition(vista)));
                getParentFragmentManager().setFragmentResult("key",bundle);
            }
        });
 */
    }
}