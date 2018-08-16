package android.oscarbetanzos.com.petinsta.Adapters;

import android.app.Activity;
import android.oscarbetanzos.com.petinsta.Db.ConstructorMiMascota;
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

public class MiMascotaAdaptador extends RecyclerView.Adapter<MiMascotaAdaptador.MiMascotaViewHolder> {
    ArrayList<Mascota> MiMascota;
    Activity activity;

    public MiMascotaAdaptador(ArrayList<Mascota> miMascota, Activity activity) {
        this.MiMascota = miMascota;
        this.activity = activity;
    }

    @Override
    public MiMascotaAdaptador.MiMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mimascota,parent,false);
        return new MiMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MiMascotaAdaptador.MiMascotaViewHolder miMascotaViewHolder, int position) {
        final Mascota mascota = MiMascota.get(position);
        miMascotaViewHolder.tvRateMM.setText(mascota.getRate());
        miMascotaViewHolder.imgMascotaMM.setImageResource(mascota.getFoto());

        miMascotaViewHolder.imgButtonMM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstructorMiMascota constructorMiMascota = new ConstructorMiMascota(activity);
                constructorMiMascota.darLikeFotoMiMascota(mascota.getId());
                mascota.setRate(String.valueOf(constructorMiMascota.obtenerLikeFotoMiMascota(mascota.getId())));
                miMascotaViewHolder.tvRateMM.setText(mascota.getRate());
            }
        });
    }

    @Override
    public int getItemCount() {
        return MiMascota.size();
    }

    public static class MiMascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView   imgMascotaMM;
        private TextView    tvRateMM;
        private ImageButton imgButtonMM;

        public MiMascotaViewHolder(View itemView) {
            super(itemView);

            imgMascotaMM    = (ImageView)   itemView.findViewById(R.id.imgMascotaMM);
            tvRateMM        = (TextView)    itemView.findViewById(R.id.tvRateMM);
            imgButtonMM     = (ImageButton) itemView.findViewById(R.id.imgButtonMM);
        }
    }
}
