package android.oscarbetanzos.com.petinsta.Db;

import android.content.ContentValues;
import android.content.Context;
import android.oscarbetanzos.com.petinsta.pojo.Mascota;
import android.oscarbetanzos.com.petinsta.R;

import java.util.ArrayList;

public class ConstructorMiMascota {
    private Context context;

    public ConstructorMiMascota(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerFotosMiMascota(){
        BaseDatos baseDatos = new BaseDatos(context);
        inicializarFotosMiMascota(baseDatos);
        return baseDatos.obtenerFotosMiMascota();
    }

    public void darLikeFotoMiMascota(int id){
        BaseDatos baseDatos = new BaseDatos(context);
        baseDatos.agregarLikeMiMascota(id);
        baseDatos.close();
    }

    public int obtenerLikeFotoMiMascota(int id){
       BaseDatos baseDatos = new BaseDatos(context);
       return baseDatos.obtenerLikeMiMascota(id);
    }

    public void inicializarFotosMiMascota(BaseDatos db){

        if (db.contarMisMascotas()==0){
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBD.TAB_MYPET_FOTO,R.drawable.sb2);
            contentValues.put(ConstantesBD.TAB_MYPET_NUMERO_LIKES,0);
            db.agregarFotoMiMascota(contentValues);

            contentValues.put(ConstantesBD.TAB_MYPET_FOTO,R.drawable.sb3);
            contentValues.put(ConstantesBD.TAB_MYPET_NUMERO_LIKES,0);
            db.agregarFotoMiMascota(contentValues);

            contentValues.put(ConstantesBD.TAB_MYPET_FOTO,R.drawable.sb4);
            contentValues.put(ConstantesBD.TAB_MYPET_NUMERO_LIKES,0);
            db.agregarFotoMiMascota(contentValues);

            contentValues.put(ConstantesBD.TAB_MYPET_FOTO,R.drawable.sb5);
            contentValues.put(ConstantesBD.TAB_MYPET_NUMERO_LIKES,0);
            db.agregarFotoMiMascota(contentValues);

            contentValues.put(ConstantesBD.TAB_MYPET_FOTO,R.drawable.sb6);
            contentValues.put(ConstantesBD.TAB_MYPET_NUMERO_LIKES,0);
            db.agregarFotoMiMascota(contentValues);

            contentValues.put(ConstantesBD.TAB_MYPET_FOTO,R.drawable.sb7);
            contentValues.put(ConstantesBD.TAB_MYPET_NUMERO_LIKES,0);
            db.agregarFotoMiMascota(contentValues);

            contentValues.put(ConstantesBD.TAB_MYPET_FOTO,R.drawable.sb8);
            contentValues.put(ConstantesBD.TAB_MYPET_NUMERO_LIKES,0);
            db.agregarFotoMiMascota(contentValues);

            contentValues.put(ConstantesBD.TAB_MYPET_FOTO,R.drawable.sb9);
            contentValues.put(ConstantesBD.TAB_MYPET_NUMERO_LIKES,0);
            db.agregarFotoMiMascota(contentValues);

            contentValues.put(ConstantesBD.TAB_MYPET_FOTO,R.drawable.sb10);
            contentValues.put(ConstantesBD.TAB_MYPET_NUMERO_LIKES,0);
            db.agregarFotoMiMascota(contentValues);
        }
    }
}
