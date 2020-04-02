package com.example.coronaLiveUpdates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNav = findViewById(R.id.nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        Bundle b = getIntent().getExtras();
        String countrysel = b.getString("MY_COU");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Fragment_ParticularCountry(countrysel)).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new Fragment_Home();
                            break;
                        case R.id.nav_countryWise:
                            selectedFragment = new Fragment_CountryWise();
                            Toast.makeText(HomeActivity.this,"Loading...", Toast.LENGTH_LONG).show();
                            break;
                        case R.id.nav_particularCountry:
                            Bundle b = getIntent().getExtras();
                            String countrysel = b.getString("MY_COU");
                             selectedFragment = new Fragment_ParticularCountry(countrysel);
                            Toast.makeText(HomeActivity.this,"Loading...", Toast.LENGTH_LONG).show();
                                break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }

            };
}



