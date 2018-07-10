package com.pepe.cuesta;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CHENAO on 3/07/2017.
 */

public class AdaptadorDulces
        extends RecyclerView.Adapter<AdaptadorDulces.ViewHolderDulces>
        implements View.OnClickListener{

    ArrayList<dulceInfo> listaDulces;
    private View.OnClickListener listener;

    public AdaptadorDulces(ArrayList<dulceInfo> listaDulces) {
        this.listaDulces = listaDulces;
    }

    @Override
    public ViewHolderDulces onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout=0;
        if (Utilidades.visualizacion==Utilidades.LIST){
            layout=R.layout.iem_lista_de_dulces;
        }else {
            layout=R.layout.iem_grid_lista_de_dulces;
        }

        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null,false);

        view.setOnClickListener(this);

        return new ViewHolderDulces(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDulces holder, int position) {
        holder.etiNombre.setText(listaDulces.get(position).getNombre());

        if (Utilidades.visualizacion==Utilidades.LIST){
            holder.etiInformacion.setText(listaDulces.get(position).getInfo());
        }

        holder.foto.setImageResource(listaDulces.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaDulces.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderDulces extends RecyclerView.ViewHolder {

        TextView etiNombre,etiInformacion;
        ImageView foto;

        public ViewHolderDulces(View itemView) {
            super(itemView);
            etiNombre= (TextView) itemView.findViewById(R.id.idNombre);
            if (Utilidades.visualizacion==Utilidades.LIST){
                etiInformacion= (TextView) itemView.findViewById(R.id.idInfo);
            }
            foto= (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}
