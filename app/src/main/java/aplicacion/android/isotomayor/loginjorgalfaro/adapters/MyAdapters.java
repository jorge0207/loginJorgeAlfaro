package aplicacion.android.isotomayor.loginjorgalfaro.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import aplicacion.android.isotomayor.loginjorgalfaro.R;
import aplicacion.android.isotomayor.loginjorgalfaro.models.alumno;

public class MyAdapters extends BaseAdapter {
    private List<alumno> list;
    private int layout;
    private Context context;

    public MyAdapters(List<alumno> list, int layout, Context context) {
        this.list = list;
        this.layout = layout;
        this.context = context;
    }





    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.id = (TextView) convertView.findViewById(R.id.textView_id);
            vh.rut = (TextView) convertView.findViewById(R.id.textView_rut);
            vh.nombre = (TextView) convertView.findViewById(R.id.textView_nombre);
            vh.edad = (TextView) convertView.findViewById(R.id.textView_edad);
            vh.direccion = (TextView) convertView.findViewById(R.id.textView_direccion);
            vh.sueldo = (TextView) convertView.findViewById(R.id.textView_sueldo);
            vh.cargo = (TextView) convertView.findViewById(R.id.textView_cargo);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();

        }
        alumno p = list.get(position);
        vh.id.setText(p.getId() + "");
        vh.rut.setText(p.getRut() + "");
        vh.nombre.setText(p.getNombre());
        vh.edad.setText(p.getEdad()+"");
        vh.direccion.setText(p.getDireccion()+"");
        vh.sueldo.setText(p.getSueldo());
        vh.cargo.setText(p.getCargo());
        return convertView;
    }


    public class ViewHolder {
        TextView id;
        TextView rut;
        TextView nombre;
        TextView edad;
        TextView direccion;
        TextView carrera;
        TextView sueldo;
        TextView cargo;
    }
}
