package dev.samuel.teste.agenda.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import dev.samuel.teste.agenda.R;
import dev.samuel.teste.agenda.controller.ImcContoller;
import dev.samuel.teste.agenda.model.Calculadora;

/*
Autor: Juan Francisco Sánchez González
Fecha: 07/02/2023
Clase: Actividad que contiene la barra de menú lateral (NavigationDrawer). Para cargar el contenido de la activity
se utiliza un ViewFlipper.
*/

public class MainActivity extends AppCompatActivity {

    // Constante Contenido Actividad
    private final static int CONT_ACTIVIDAD = 0;
    private DrawerLayout drawerLayout;
    private NavigationView nav;
    private ViewFlipper vf;
    Toolbar toolbar;

    //Main

    Calculadora calculadora;
    Calculadora outraCalculadora;

    ImcContoller controller;

    EditText edit_Peso;
    EditText edit_Altura;
    TextView text_Resultado;

    Button btnbuton_Limpar;
    Button btnbuton_Salvar;
    Button btnbuton_Finalizar;

    Button btn_calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar1);

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
//                    sendIntent = new Intent(MainActivity.this, MainActivity.class);
//                    startActivity(sendIntent);
                } else if (item.getItemId() == R.id.nav_item_two) {
                    // Se inicia Actividad 2
                    sendIntent = new Intent(MainActivity.this, Activity2.class);
                    startActivity(sendIntent);
                } else if (item.getItemId() == R.id.nav_item_three) {
                    // Se inicia Actividad 3
                    sendIntent = new Intent(MainActivity.this, Activity3.class);
                    startActivity(sendIntent);
                }

                // Close the navigation drawer when an item is selected
                drawerLayout.closeDrawers();
                return true;
            }
        });



        controller = new ImcContoller(MainActivity.this);
        controller.toString();

        outraCalculadora = new Calculadora();
        controller.buscar(outraCalculadora);

        edit_Peso = findViewById(R.id.editPeso);
        edit_Altura = findViewById(R.id.editAltura);
        text_Resultado = findViewById(R.id.textResultado);

        btnbuton_Limpar = findViewById(R.id.button_Limpar);
        btnbuton_Salvar = findViewById(R.id.button_Salvar);
        btnbuton_Finalizar = findViewById(R.id.button_Finalizar);
        btn_calcular = findViewById(R.id.button_Calcular);

        edit_Peso.setText(outraCalculadora.getPeso());
        edit_Altura.setText(outraCalculadora.getAltura());
        text_Resultado.setText(outraCalculadora.getResultado());

        btnbuton_Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_Peso.setText("");
                edit_Altura.setText("");

            }
        });

        btnbuton_Finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, " Volte ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnbuton_Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                outraCalculadora.setPeso(edit_Peso.getText().toString());
                outraCalculadora.setAltura(edit_Altura.getText().toString());
                outraCalculadora.setResultado(text_Resultado.getText().toString());


                Toast.makeText(MainActivity.this, " Salvo ", Toast.LENGTH_SHORT).show();
                controller.salvar(outraCalculadora);

            }
        });
        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularImc(v);
            }
        });
    }

    public void calcularImc(View view){
        double peso = Double.parseDouble(edit_Peso.getText().toString());
        double altura = Double.parseDouble(edit_Altura.getText().toString());
        double resultado = (peso / (altura * altura));

        if(resultado < 19){
            text_Resultado.setText((String.format("Abaixo do peso %.2f", resultado)));

        } else if (resultado < 30){
            text_Resultado.setText((String.format("Peso normal %.2f", resultado)));


        } else if (resultado < 40) {
            text_Resultado.setText((String.format("Sobrepeso %.2f", resultado)));
        }
    }


}