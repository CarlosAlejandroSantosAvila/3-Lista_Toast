package com.example.AlejandroSantos.Toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends Activity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado);


        ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();

        datos.add(new Lista_entrada(R.drawable.art_clouds, "Lunes", "Nunblado.","22c"));
        datos.add(new Lista_entrada(R.drawable.art_light_clouds, "Martes", "Parcialmente Nublado.","24c"));
        datos.add(new Lista_entrada(R.drawable.art_rain, "Miercoles", "Lluvioso.","19c"));
        datos.add(new Lista_entrada(R.drawable.art_storm, "Jueves", "Tormentas.","19c"));
        datos.add(new Lista_entrada(R.drawable.art_storm, "Viernes", "Tormentas","36c"));
        datos.add(new Lista_entrada(R.drawable.art_clear, "Sabado", "Soleado.","29c"));
        datos.add(new Lista_entrada(R.drawable.art_rain, "Domingo", "Lluvia","25c"));


        lista = (ListView) findViewById(R.id.ListView_listado);
        lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_dia);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Lista_entrada) entrada).get_textoDia());

                    TextView texto_grados_entrada = (TextView) view.findViewById(R.id.textView_grados);
                    if (texto_grados_entrada != null)
                        texto_grados_entrada.setText(((Lista_entrada) entrada).get_textoGrados());

                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_estado);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((Lista_entrada) entrada).get_textoEstado());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
                }
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion);

                CharSequence texto = "Seleccionado: " + elegido.get_textoEstado();
                Toast toast = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
                toast.show();
            }
        });



    }

}
