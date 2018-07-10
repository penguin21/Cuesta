package com.pepe.cuesta;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class lista_dulces extends AppCompatActivity {

    ArrayList<dulceInfo> listaDulces;
    RecyclerView recyclerDulces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_dulces);

        construirRecycler();

    }

    private void llenarDulces() {
        listaDulces.add(new dulceInfo("Brazo Gitano","",R.drawable.BrazoGitano));
        listaDulces.add(new dulceInfo("Ponche","",R.drawable.Ponches));
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnList: Utilidades.visualizacion=Utilidades.LIST;
                break;
            case R.id.btnGrid: Utilidades.visualizacion=Utilidades.GRID;
                break;
        }
        construirRecycler();
    }

    private void construirRecycler() {
        listaDulces=new ArrayList<>();
        recyclerDulces= (RecyclerView) findViewById(R.id.RecyclerId);

        if (Utilidades.visualizacion==Utilidades.LIST){
            recyclerDulces.setLayoutManager(new LinearLayoutManager(this));
        }else {
            recyclerDulces.setLayoutManager(new GridLayoutManager(this,3));
        }

        llenarDulces();

        AdaptadorDulces adapter=new AdaptadorDulces(listaDulces);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Selección: "+listaDulces.get
                                (recyclerDulces.getChildAdapterPosition(view))
                                .getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

        recyclerDulces.setAdapter(adapter);
    }
}
