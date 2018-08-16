package android.oscarbetanzos.com.petinsta.Db;

import android.content.ContentValues;
import android.content.Context;
import android.oscarbetanzos.com.petinsta.pojo.Mascota;
import android.oscarbetanzos.com.petinsta.R;

import java.util.ArrayList;

public class ConstructorMascota {
    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascota(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMascotas(){
        BaseDatos db = new BaseDatos(context);
        iniciarMascotas(db);
        return db.ObtenerMascotas();

    }

    public void iniciarMascotas(BaseDatos baseDatos){

        //Log.v("Numero Mascotas ",String.valueOf(baseDatos.contarMascotas()));
        if (baseDatos.contarMascotas()==0) {
            ContentValues contentValues = new ContentValues();

            contentValues.put(ConstantesBD.TAB_MASCOTAS_NOMBRE, "Hook");
            contentValues.put(ConstantesBD.TAB_MASCOTAS_FOTO, R.drawable.bulyteryer);
            baseDatos.insertarMascota(contentValues);

            contentValues.put(ConstantesBD.TAB_MASCOTAS_NOMBRE, "Peyton");
            contentValues.put(ConstantesBD.TAB_MASCOTAS_FOTO, R.drawable.labrador);
            baseDatos.insertarMascota(contentValues);

            contentValues.put(ConstantesBD.TAB_MASCOTAS_NOMBRE, "Cali");
            contentValues.put(ConstantesBD.TAB_MASCOTAS_FOTO, R.drawable.mittelyshnauter);
            baseDatos.insertarMascota(contentValues);

            contentValues.put(ConstantesBD.TAB_MASCOTAS_NOMBRE, "Moon moon");
            contentValues.put(ConstantesBD.TAB_MASCOTAS_FOTO, R.drawable.huskies);
            baseDatos.insertarMascota(contentValues);

            contentValues.put(ConstantesBD.TAB_MASCOTAS_NOMBRE, "Lua");
            contentValues.put(ConstantesBD.TAB_MASCOTAS_FOTO, R.drawable.chihuahua);
            baseDatos.insertarMascota(contentValues);

            contentValues.put(ConstantesBD.TAB_MASCOTAS_NOMBRE, "Chispa");
            contentValues.put(ConstantesBD.TAB_MASCOTAS_FOTO, R.drawable.daschound);
            baseDatos.insertarMascota(contentValues);

            contentValues.put(ConstantesBD.TAB_MASCOTAS_NOMBRE, "Chester");
            contentValues.put(ConstantesBD.TAB_MASCOTAS_FOTO, R.drawable.bulyteryer2);
            baseDatos.insertarMascota(contentValues);
        }
    }

    public void darLike(Mascota mascota){
        BaseDatos baseDatos = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TAB_LIKES_ID_MASCOTA,mascota.getId());
        contentValues.put(ConstantesBD.TAB_LIKES_NUMERO_LIKES, LIKE);
        baseDatos.insertarLike(contentValues);
        baseDatos.close();
    }

    public int obtenerLikes(Mascota mascota){
        BaseDatos baseDatos = new BaseDatos(context);
        mascota.setRate(String.valueOf(baseDatos.contarLikes(mascota)));
        return baseDatos.contarLikes(mascota);
    }


}
