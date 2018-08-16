package android.oscarbetanzos.com.petinsta.presentador;

import android.content.Context;
import android.oscarbetanzos.com.petinsta.Db.ConstructorMascota;
import android.oscarbetanzos.com.petinsta.Fragments.IRVHomeFragmentView;
import android.oscarbetanzos.com.petinsta.pojo.Mascota;

import java.util.ArrayList;

public class HomeFragmentPresentador implements IRVHomeFragmentPresentador{
    private IRVHomeFragmentView irvHomeFragmentView;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> mascotas;

    public HomeFragmentPresentador(IRVHomeFragmentView irvHomeFragmentView, Context context) {
        this.irvHomeFragmentView = irvHomeFragmentView;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMascota = new ConstructorMascota(context);
        mascotas = constructorMascota.obtenerMascotas();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        irvHomeFragmentView.inicializarAdaptador(
                irvHomeFragmentView.crearAdaptador(mascotas));
        irvHomeFragmentView.generarLayoutManagerRV();

    }
}
