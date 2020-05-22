package com.sirpla.recyclerviewanidadas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DetalleAdapter extends RecyclerView.Adapter<DetalleAdapter.ViewHolder> {
    //Se inicializa el vector de detalle
     List<String> _listaDetalle;
     
     //Se crea el constructor
     public DetalleAdapter(List<String> listaDetalle){
         this._listaDetalle=listaDetalle;
    }
     
     @NonNull
     @Override
     public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          //Se infla el layout del recyclerview de detalle
          View view = LayoutInflater.from( parent.getContext() )
                  .inflate( R.layout.detalle_list_row, parent, false );
          
          return new DetalleAdapter.ViewHolder(view  );
     }
     
     @Override
     public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          //Seteo el detalle en el textview
          holder.txtNombre.setText( _listaDetalle.get(position) );
     }
     
     @Override
     public int getItemCount() {
          //retorno el tamaño de la lista
          return _listaDetalle.size();
     }
     
     public class ViewHolder extends RecyclerView.ViewHolder {
          //Inicializar la variable
          TextView txtNombre;
          
          public ViewHolder(@NonNull View itemView) {
               super( itemView );
               //Asignación de Variables
               txtNombre = itemView.findViewById( R.id.textview_nombre );
          }
     }
}
