package pe.edu.ulima.pc1_pichangers.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

import pe.edu.ulima.pc1_pichangers.AgregarActivity;
import pe.edu.ulima.pc1_pichangers.InfoActivity;
import pe.edu.ulima.pc1_pichangers.R;
import pe.edu.ulima.pc1_pichangers.beans.Equipo;

public class ListadoEquiposAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Equipo> mEquipos;
    private Context mContext;

    public ListadoEquiposAdapter(Context context, List<Equipo> equipos){
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mEquipos = equipos;
    }
    @Override
    public int getCount() {
        return mEquipos.size();
    }

    @Override
    public Object getItem(int i) {
        return mEquipos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mEquipos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = mInflater.inflate(R.layout.item_listado_equipos, null);
            viewHolder = new ViewHolder();
            viewHolder.iviEquipoFoto =(ImageView) view.findViewById(R.id.iviEquipoFoto);
            viewHolder.tviNombreEquipo = (TextView) view.findViewById(R.id.tviNombreEquipo);


            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

       Equipo equipo = mEquipos.get(i);

        viewHolder.tviNombreEquipo.setText(equipo.getNombre());

        Log.i("Pichangers", equipo.getUrlImagen());
        Picasso.with(mContext)
                .load(equipo.getUrlImagen())
                .resize(200, 200)
                .centerCrop()
                .into(viewHolder.iviEquipoFoto);

        return view;
    }

    class ViewHolder{
        ImageView iviEquipoFoto;
        TextView tviNombreEquipo;

    }
}