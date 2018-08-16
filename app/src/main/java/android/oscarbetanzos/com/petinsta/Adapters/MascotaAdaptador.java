package android.oscarbetanzos.com.petinsta.Adapters;

import android.app.Activity;
import android.oscarbetanzos.com.petinsta.Db.ConstructorMascota;
import android.oscarbetanzos.com.petinsta.pojo.Mascota;
import android.oscarbetanzos.com.petinsta.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;


    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity= activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvRate.setText(mascota.getRate());

        mascotaViewHolder.imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstructorMascota constructorMascota = new ConstructorMascota(activity);
                constructorMascota.darLike(mascota);
                mascotaViewHolder.tvRate.setText(String.valueOf(constructorMascota.obtenerLikes(mascota)));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView tvNombre;
        private TextView tvRate;
        private ImageButton imgButton;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgMascota = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvNombre =   (TextView) itemView.findViewById(R.id.tvNombre);
            tvRate =     (TextView) itemView.findViewById(R.id.tvRate);
            imgButton=   (ImageButton) itemView.findViewById(R.id.imgButton);
        }
    }



}
