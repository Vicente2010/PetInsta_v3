package android.oscarbetanzos.com.petinsta.Fragments;

import android.oscarbetanzos.com.petinsta.Adapters.MiMascotaAdaptador;
import android.oscarbetanzos.com.petinsta.pojo.Mascota;

import java.util.ArrayList;

public interface IRVMiMascotaFragView {

    public void generarLayoutManagerRV();

    public MiMascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptador(MiMascotaAdaptador miMascotaAdaptador);


}
