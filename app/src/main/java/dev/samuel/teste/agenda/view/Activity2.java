package dev.samuel.teste.agenda.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import dev.samuel.teste.agenda.DAO.AlunoDAO;
import dev.samuel.teste.agenda.R;


public class Activity2 extends AppCompatActivity {

    // Constante Contenido Actividad
    private final static int CONT_ACTIVIDAD = 1;

    private DrawerLayout drawerLayout;
    private NavigationView nav;
    private ViewFlipper vf;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar2);


        // Componente ViewFlipper
        vf = findViewById(R.id.vf);
        vf.setDisplayedChild(CONT_ACTIVIDAD);

        // Componente NavigationDrawer
        drawerLayout = findViewById(R.id.drawer_layout);
        nav = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent sendIntent;
                if (item.getItemId() == R.id.nav_item_one) {
                    // Se inicia Actividad 1
                    sendIntent = new Intent(Activity2.this, MainActivity.class);
                    startActivity(sendIntent);
                } else if (item.getItemId() == R.id.nav_item_two) {
                    // Se inicia Actividad 2
//                    sendIntent = new Intent(Activity2.this, Activity2.class);
//                    startActivity(sendIntent);
                } else if (item.getItemId() == R.id.nav_item_three) {
                    // Se inicia Actividad 3
                    sendIntent = new Intent(Activity2.this, Activity3.class);
                    startActivity(sendIntent);
                }

                // Close the navigation drawer when an item is selected
                drawerLayout.closeDrawers();
                return true;
            }
        });
        
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_novo_alunos);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity2.this,
                        Activity3.class));
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();

        AlunoDAO dao = new AlunoDAO();

        ListView listaDeAlunos = findViewById(R.id.activity_lista);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, dao.todos()));
    }

}