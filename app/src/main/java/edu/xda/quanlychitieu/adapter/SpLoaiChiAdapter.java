package edu.xda.quanlychitieu.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.xda.quanlychitieu.R;
import edu.xda.quanlychitieu.model.LoaiChi;

public class SpLoaiChiAdapter extends ArrayAdapter<LoaiChi> {
    private Context context;
    private ArrayList<LoaiChi> data;
    public Resources res;
    private LayoutInflater inflater;

    public SpLoaiChiAdapter(Context context, ArrayList<LoaiChi> objects) {
        super(context, R.layout.custom_sp_loai_thu, objects);

        this.context = context;
        data = objects;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.custom_sp_loai_thu, parent, false);
        TextView txtLoaiThuSp = (TextView) row.findViewById(R.id.txtCustomSpLoaiThu);

        txtLoaiThuSp.setText(data.get(position).getTenLoaiChi());

        return row;
    }

}
