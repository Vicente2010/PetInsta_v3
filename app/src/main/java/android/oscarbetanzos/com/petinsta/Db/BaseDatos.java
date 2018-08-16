package android.oscarbetanzos.com.petinsta.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.oscarbetanzos.com.petinsta.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper{
    private Context context;

    public BaseDatos(Context context ) {
        super(context, ConstantesBD.DB_NAME, null, ConstantesBD.DT_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBD.TAB_MASCOTAS + "(" +
                ConstantesBD.TAB_MASCOTAS_ID        + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TAB_MASCOTAS_NOMBRE    + " TEXT, " +
                ConstantesBD.TAB_MASCOTAS_FOTO      + " INTEGER" +
                ")";

        String queryCrearTablaLikes = "CREATE TABLE " + ConstantesBD.TAB_LIKES + "(" +
                ConstantesBD.TAB_LIKES_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TAB_LIKES_ID_MASCOTA   + " INTEGER, " +
                ConstantesBD.TAB_LIKES_NUMERO_LIKES + " INTEGER" +
                ")";

        String queryCrearTablaMiMascota = "CREATE TABLE " + ConstantesBD.TAB_MYPET + "(" +
                ConstantesBD.TAB_MYPET_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TAB_MYPET_FOTO         + " INTEGER, " +
                ConstantesBD.TAB_MYPET_NUMERO_LIKES + " INTEGER" +
                ")";

        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaLikes);
        db.execSQL(queryCrearTablaMiMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TAB_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TAB_LIKES);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TAB_MYPET);
        onCreate(db);
    }

    public ArrayList<Mascota> ObtenerMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String queryObtenerMascotas = "SELECT * FROM " + ConstantesBD.TAB_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(queryObtenerMascotas,null);

        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();

            mascotaActual.setId     (registros.getInt   (0));
            mascotaActual.setNombre (registros.getString(1));
            mascotaActual.setFoto   (registros.getInt   (2));
            mascotaActual.setRate   (String.valueOf(contarLikes(mascotaActual)));
            mascotas.add(mascotaActual);
        }

        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TAB_MASCOTAS,null, contentValues);
        db.close();
    }

    public int contarMascotas(){
        int numeroRegistros=0;
        String queryContarMascotas = "SELECT COUNT(*) FROM " + ConstantesBD.TAB_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registrosContar = db.rawQuery(queryContarMascotas,null);
        if (registrosContar.moveToNext()){
            numeroRegistros= registrosContar.getInt(0);
        }

        db.close();
        return numeroRegistros;

    }

    public void insertarLike(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TAB_LIKES,null,contentValues);
        db.close();
    }

    public int contarLikes(Mascota mascota){
        int likes = 0;

        String queryContarLikes = "SELECT COUNT(" + ConstantesBD.TAB_LIKES_NUMERO_LIKES + ")" +
                " FROM "    + ConstantesBD.TAB_LIKES +
                " WHERE "   + ConstantesBD.TAB_LIKES_ID_MASCOTA + "=" + mascota.getId();

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor registrosLikes = database.rawQuery(queryContarLikes,null);

        if (registrosLikes.moveToNext()) {
            likes = registrosLikes.getInt(0);
        }
        database.close();

        return likes;
    }

    //METODOS PARA TABLA MI MASCOTA **********

    public ArrayList<Mascota> obtenerFotosMiMascota(){
        ArrayList<Mascota> miMascotaFotos = new ArrayList<>();

        String queryObtenerMiMascota = "SELECT * FROM " + ConstantesBD.TAB_MYPET;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(queryObtenerMiMascota,null);

        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();

            mascotaActual.setId     (registros.getInt   (0));
            mascotaActual.setNombre ("Kala");
            mascotaActual.setFoto   (registros.getInt   (1));
            mascotaActual.setRate   (registros.getString(2));
            miMascotaFotos.add(mascotaActual);
        }

        db.close();
        return miMascotaFotos;
    }

    public void agregarFotoMiMascota(ContentValues contentValues){
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(ConstantesBD.TAB_MYPET,null,contentValues);
        database.close();

    }


    public void agregarLikeMiMascota(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String querySumarLike = "UPDATE " + ConstantesBD.TAB_MYPET +
                " SET " + ConstantesBD.TAB_MYPET_NUMERO_LIKES + "=" + ConstantesBD.TAB_MYPET_NUMERO_LIKES + "+ 1" +
                " WHERE " + ConstantesBD.TAB_MYPET_ID + "=" + id;
        db.execSQL(querySumarLike);

        db.close();
    }

    public int obtenerLikeMiMascota(int id){
        int likes = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        String querySumarLike = "SELECT " + ConstantesBD.TAB_MYPET_NUMERO_LIKES +
                " FROM " + ConstantesBD.TAB_MYPET +
                " WHERE " + ConstantesBD.TAB_MYPET_ID + "=" + id;
        Cursor miMascotaLikes = db.rawQuery(querySumarLike,null);
        if (miMascotaLikes.moveToNext()){likes = miMascotaLikes.getInt(0);}
        db.close();
        return likes;
    }
    public int contarMisMascotas(){
        int numeroRegistros=0;
        String queryContarMisMascotas = "SELECT * FROM " + ConstantesBD.TAB_MYPET;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registrosContar = db.rawQuery(queryContarMisMascotas,null);
        numeroRegistros = registrosContar.getCount();
        db.close();
        return numeroRegistros;

    }


    public int[] obtenerIds(){
        int ids[];
        int i=0;
        SQLiteDatabase database = this.getWritableDatabase();
        String queryObtenerIds = "SELECT " + ConstantesBD.TAB_MASCOTAS_ID + " FROM " + ConstantesBD.TAB_MASCOTAS;
        Cursor registrosIds = database.rawQuery(queryObtenerIds,null);

        ids= new int[registrosIds.getCount()];
        while(registrosIds.moveToNext()){
            ids[i]=registrosIds.getInt(0);
            i++;
        }

        return ids;
    }

    public Mascota getMascotaById(int id){
        String queryObtenerMascotas = "SELECT * FROM " + ConstantesBD.TAB_MASCOTAS +
                " WHERE " + ConstantesBD.TAB_MASCOTAS_ID + "=" + id;
        Mascota mascotaAux = new Mascota();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor registroMascota = database.rawQuery(queryObtenerMascotas,null);
        if (registroMascota.moveToNext()){
            mascotaAux.setId    (id);
            mascotaAux.setNombre(registroMascota.getString(1));
            mascotaAux.setFoto  (registroMascota.getInt(2));
            mascotaAux.setRate  (String.valueOf(contarLikes(mascotaAux)));
        }
        return mascotaAux;
    }
}
