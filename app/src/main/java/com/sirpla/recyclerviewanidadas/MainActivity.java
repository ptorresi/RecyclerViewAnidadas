package com.sirpla.recyclerviewanidadas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     //Inicializo las Variables
     RecyclerView recyclerViewGrupo;
     List <String> grupoList;
     LinearLayoutManager layoutManagerGrupo;
     GrupoAdapter grupoAdapter;
     
     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate( savedInstanceState );
          setContentView( R.layout.activity_main );
          
          ConfigActivity();
     }
     
     private void ConfigActivity(){
          //Asigno Variable
          recyclerViewGrupo = findViewById( R.id.recyclerView_Grupo );
          
          //Uso un for para crear la cabecera del grupo
          grupoList = new ArrayList <>(  );
          for(int i=1; i<=10; i++){
               grupoList.add( "Grupo " + i  );
          }
          //Seinicializar el adapter para el grupo
          grupoAdapter= new GrupoAdapter( this, grupoList );
          //Inicializar el Layout Manager
          layoutManagerGrupo = new LinearLayoutManager( this );
          //Setear el Layout Manager
          recyclerViewGrupo.setLayoutManager( layoutManagerGrupo );
          //Setear Adapter
          recyclerViewGrupo.setAdapter( grupoAdapter );
     }
}
