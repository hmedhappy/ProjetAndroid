package ahmed.ferah.space_app;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycleView ;
    String s1[] , s2[];

    int images[] = {R.drawable.eearth,R.drawable.jjupiter,R.drawable.mmars,R.drawable.mmercury,R.drawable.nneptune,R.drawable.ppluto,R.drawable.ssaturne,R.drawable.uuranus,R.drawable.vvenus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_quiz,R.id.navigation_compte)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        recycleView = findViewById(R.id.recycleView);

        s1 = getResources().getStringArray(R.array.planet_items);
        s2 = getResources().getStringArray(R.array.descriptions);

        MyAdapter myAdapter = new MyAdapter(this,s1 ,s2,images);
        recycleView.setAdapter(myAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
    }

}