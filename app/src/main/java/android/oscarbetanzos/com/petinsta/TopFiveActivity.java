package android.oscarbetanzos.com.petinsta;

import android.oscarbetanzos.com.petinsta.Adapters.MascotaAdaptador;
import android.oscarbetanzos.com.petinsta.Db.ConstructorMascota;
import android.oscarbetanzos.com.petinsta.pojo.Mascota;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class TopFiveActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> topFiveMascotas;
    String[] topNombres;
    String[] topRates;
    int[] topFoto;
    RecyclerView listaTopFive;
    Toolbar miActionBar;
    int[] rates;
    int[] indices = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_five);

        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listaTopFive = (RecyclerView) findViewById(R.id.rvTopFive);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaTopFive.setLayoutManager(llm);

        ConstructorMascota constructorMascota = new ConstructorMascota(this);
        mascotas = constructorMascota.obtenerMascotas();

        rates = new int[mascotas.size()];
        for (int i=0; i<rates.length;i++){ rates[i]=Integer.parseInt(mascotas.get(i).getRate()); }
        topCinco(rates);
        crearTopFive(mascotas,indices);


        inicializarAdaptador();

    }

    public void crearTopFive(ArrayList<Mascota> mascotas,int[] indices){
        topFiveMascotas = new ArrayList<Mascota>();
        Mascota mascotaAux = new Mascota();
        for (int i=0;i<5;i++) {
            mascotaAux = mascotas.get(indices[i]);
            topFiveMascotas.add(mascotaAux);
        }
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(topFiveMascotas,this);
        listaTopFive.setAdapter(adaptador);
    }



    public void topCinco(int[] rates){
        int i;
        int max = 0;
        int indiceAux;
        for (int j=0; j<5; j++){
            max = rates[0];
            indiceAux = 0;
            for (i =1; i<rates.length; i++){
                if (max< rates[i]){
                    max=rates[i];
                    indiceAux=i;
                }
            }
            indices[j]=indiceAux;
            rates[indiceAux]=Integer.MIN_VALUE;
        }
    }

}
