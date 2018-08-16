package android.oscarbetanzos.com.petinsta.Fragments;

import android.os.Bundle;
import android.oscarbetanzos.com.petinsta.Adapters.MiMascotaAdaptador;
import android.oscarbetanzos.com.petinsta.pojo.Mascota;
import android.oscarbetanzos.com.petinsta.R;
import android.oscarbetanzos.com.petinsta.presentador.MiMascotaFragPresentador;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MiMascotaFragment extends Fragment implements IRVMiMascotaFragView{

    private RecyclerView rvMiMascota;
    private MiMascotaFragPresentador miMascotaFragPresentador;

    public MiMascotaFragment(){
        //constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mimascota,container,false);
        rvMiMascota = (RecyclerView) v.findViewById(R.id.rvMiMascota);
        miMascotaFragPresentador = new MiMascotaFragPresentador(getContext(),this);
        return v;
    }

    @Override
    public void generarLayoutManagerRV() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        rvMiMascota.setLayoutManager(glm);
    }

    @Override
    public MiMascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MiMascotaAdaptador adaptador = new MiMascotaAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(MiMascotaAdaptador miMascotaAdaptador) {
        rvMiMascota.setAdapter(miMascotaAdaptador);
    }







}
