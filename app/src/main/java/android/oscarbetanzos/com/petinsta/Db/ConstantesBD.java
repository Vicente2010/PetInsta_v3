package android.oscarbetanzos.com.petinsta.Db;

public class ConstantesBD {

    public static final String  DB_NAME     = "mascotas";
    public static final int     DT_VERSION  = 1;

    //TABLA MASCOTAS
    public static final String  TAB_MASCOTAS        = "mascotas";
    public static final String  TAB_MASCOTAS_ID     = "id";
    public static final String  TAB_MASCOTAS_NOMBRE = "nombre";
    public static final String  TAB_MASCOTAS_FOTO   = "foto";

    //Tabla LIKES MASCOTAS

    public static final String  TAB_LIKES               = "likes";
    public static final String  TAB_LIKES_ID            = "id";
    public static final String  TAB_LIKES_ID_MASCOTA    = "id_mascota";
    public static final String  TAB_LIKES_NUMERO_LIKES  = "numero_likes";

    //Tabla MI MASCOTA
    public static final String  TAB_MYPET               = "mi_mascota";
    public static final String  TAB_MYPET_ID            = "id";
    public static final String  TAB_MYPET_FOTO          = "foto";
    public static final String  TAB_MYPET_NUMERO_LIKES  = "numero_likes";

}
