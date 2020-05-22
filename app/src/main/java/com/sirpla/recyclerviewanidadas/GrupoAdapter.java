package com.sirpla.recyclerviewanidadas;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GrupoAdapter extends RecyclerView.Adapter<GrupoAdapter.ViewHolder> {
     //Inicializo Activity y List
     private Activity _activity;
     private List <String> _grupoList;
     
     //Crear Constructor
     GrupoAdapter(Activity activity, List<String> grupoList){
          this._activity=activity;
          this._grupoList=grupoList;
     }
     
     @NonNull
     @Override
     public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          //Inflo el layout del recyclerview
          View view = LayoutInflater.from(parent.getContext())
                  .inflate( R.layout.grupo_list_row, parent, false );
          
          return new GrupoAdapter.ViewHolder(view);
     }
     
     @Override
     public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          //Seteo el nombre del grupo
          holder.txtNombre.setText( _grupoList.get( position ) );
          
          //Inicializo la lista de detalle
          List<String> listaDetalle = new ArrayList <>(  );
          
          //Utilizo un for para agregar detalle
          for (int i=1; i<=4; i++){
               listaDetalle.add( "Detalle " + i );
          }
          
          //Inicializo el adapter del detalle
          DetalleAdapter detalleadapter = new DetalleAdapter(listaDetalle);
          //Inicializo el LayoutManager para el detalle
          LinearLayoutManager layoutManagerDetalle = new LinearLayoutManager( _activity );
          //Seteo el LayautManager
          holder.recyclerViewDetalle.setLayoutManager( layoutManagerDetalle );
          //Seteo el Adapter del Detalle
          holder.recyclerViewDetalle.setAdapter( detalleadapter );
     }
     
     @Override
     public int getItemCount() {
          //Retorno el tamaño de la lista
          return _grupoList.size();
     }
     
     public class ViewHolder extends RecyclerView.ViewHolder {
          //Inicializo Variables
          TextView txtNombre;
          RecyclerView recyclerViewDetalle;
          
          public ViewHolder(@NonNull View itemView) {
               super( itemView );
               //Asignar Variables
               txtNombre=itemView.findViewById( R.id.textview_nombre );
               recyclerViewDetalle=itemView.findViewById( R.id.recyclerView_Detalle );
          }
     }
}
