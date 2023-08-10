package dev.samuel.teste.agenda.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import dev.samuel.teste.agenda.DAO.AlunoDAO;
import dev.samuel.teste.agenda.R;
import dev.samuel.teste.agenda.model.Aluno;

/*
Autor: Juan Francisco Sánchez González
Fecha: 07/02/2023
Clase: Actividad que contiene la barra de menú lateral (NavigationDrawer). Para cargar el contenido de la activity
se utiliza un ViewFlipper.
*/

public class Activity3 extends AppCompatActivity {

    // Constante Contenido Actividad
    private final static int CONT_ACTIVIDAD = 2;

    private DrawerLayout drawerLayout;
    private NavigationView nav;
    private ViewFlipper vf;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar3);

        // Componente ViewFlipper
        vf = (ViewFlipper)findViewById(R.id.vf);
        vf.setDisplayedChild(CONT_ACTIVIDAD);

        // Componente NavigationDrawer
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nav = (NavigationView) findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));


        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent sendIntent;
                if (item.getItemId() == R.id.nav_item_one) {
                    // Se inicia Actividad 1
                    sendIntent = new Intent(Activity3.this, MainActivity.class);
                    startActivity(sendIntent);
                } else if (item.getItemId() == R.id.nav_item_two) {
                    // Se inicia Actividad 2
                    sendIntent = new Intent(Activity3.this, Activity2.class);
                    startActivity(sendIntent);
                } else if (item.getItemId() == R.id.nav_item_three) {
                    // Se inicia Actividad 3
//                    sendIntent = new Intent(Activity3.this, Activity3.class);
//                    startActivity(sendIntent);
                }

                // Close the navigation drawer when an item is selected
                drawerLayout.closeDrawers();
                return true;
            }
        });




        AlunoDAO dao = new AlunoDAO();

        EditText campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        EditText campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        EditText campoEmail = findViewById(R.id.activity_formulario_aluno_email);

        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Activity3.this, "Salvar", Toast.LENGTH_SHORT).show();

                String nome = campoNome.getText().toString();
                String telefone = campoTelefone.getText().toString();
                String email = campoEmail.getText().toString();

                Aluno alunoCriado = new Aluno(nome, telefone, email);

                dao.salva(alunoCriado);

                finish();
            }
        });



    }
}