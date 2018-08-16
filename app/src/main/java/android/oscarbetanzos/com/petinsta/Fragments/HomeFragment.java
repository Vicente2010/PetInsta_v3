package android.oscarbetanzos.com.petinsta.Fragments;

import android.os.Bundle;
import android.oscarbetanzos.com.petinsta.pojo.Mascota;
import android.oscarbetanzos.com.petinsta.Adapters.MascotaAdaptador;
import android.oscarbetanzos.com.petinsta.R;
import android.oscarbetanzos.com.petinsta.presentador.HomeFragmentPresentador;
import android.oscarbetanzos.com.petinsta.presentador.IRVHomeFragmentPresentador;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements IRVHomeFragmentView{
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRVHomeFragmentPresentador presentador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home,container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvListaMascotas);
        presentador = new HomeFragmentPresentador(this,getContext());
        return v;

    }


    @Override
    public void generarLayoutManagerRV() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(MascotaAdaptador adaptador){
        listaMascotas.setAdapter(adaptador);
    }

}
