package android.oscarbetanzos.com.petinsta.pojo;

import android.app.Application;

public class Mascota extends Application{
    private int id;
    private int foto;
    private String nombre;
    private String rate;

    public Mascota() {
    }

    public Mascota(int id, int foto, String nombre, String rate) {
        this.id = id;
        this.foto = foto;
        this.nombre = nombre;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
