package android.oscarbetanzos.com.petinsta.Fragments;

import android.oscarbetanzos.com.petinsta.Adapters.MascotaAdaptador;
import android.oscarbetanzos.com.petinsta.pojo.Mascota;

import java.util.ArrayList;

public interface IRVHomeFragmentView {

    public void generarLayoutManagerRV();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptador(MascotaAdaptador mascotaAdaptador);



}
