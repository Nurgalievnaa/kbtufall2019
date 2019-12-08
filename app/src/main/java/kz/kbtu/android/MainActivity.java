package kz.kbtu.android;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, mainFragment).commit();
    }
}

interface OnMovieClickListener {
    void onClick(Result movie);
}
