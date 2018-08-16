package android.oscarbetanzos.com.petinsta.presentador;

import android.content.Context;
import android.oscarbetanzos.com.petinsta.Db.ConstructorMiMascota;
import android.oscarbetanzos.com.petinsta.Fragments.IRVMiMascotaFragView;
import android.oscarbetanzos.com.petinsta.pojo.Mascota;

import java.util.ArrayList;

public class MiMascotaFragPresentador implements IRVHomeFragmentPresentador {
    private Context context;
    private IRVMiMascotaFragView irvMiMascotaFragView;
    private ConstructorMiMascota constructorMiMascota;
    private ArrayList<Mascota> miMascotaFotos;

    public MiMascotaFragPresentador(Context context, IRVMiMascotaFragView irvMiMascotaFragView) {
        this.context = context;
        this.irvMiMascotaFragView = irvMiMascotaFragView;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMiMascota = new ConstructorMiMascota(context);
        miMascotaFotos = constructorMiMascota.obtenerFotosMiMascota();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        irvMiMascotaFragView.inicializarAdaptador(
                irvMiMascotaFragView.crearAdaptador(miMascotaFotos));
        irvMiMascotaFragView.generarLayoutManagerRV();

    }
}
