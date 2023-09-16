package edu.xda.quanlychitieu.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.xda.quanlychitieu.R;
import edu.xda.quanlychitieu.fragment.LoaiChiFragment;
import edu.xda.quanlychitieu.model.LoaiChi;


public class LoaiChiAdapter extends RecyclerView.Adapter<LoaiChiAdapter.MyViewHolder>  {
    private List<LoaiChi> loaiChis;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    public LoaiChiAdapter(Context context, ArrayList<LoaiChi> loaiChis) {
        this.loaiChis = loaiChis;
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtNameLoaiChi;
        ImageView imgEdtLoaiChi, imgDeleteLoaiChi;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtNameLoaiChi = itemView.findViewById(R.id.txtCustomNameLoaiThu);
            imgEdtLoaiChi = itemView.findViewById(R.id.imgCustomEditLoaiThu);
            imgDeleteLoaiChi = itemView.findViewById(R.id.imgCustomDeleteLoaiThu);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = mLayoutInflater.inflate(R.layout.custom_loai_thu,parent,false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final LoaiChi loaiChi = loaiChis.get(position);
        holder.txtNameLoaiChi.setText(loaiChi.getTenLoaiChi());
        holder.imgDeleteLoaiChi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("Bạn có muốn xóa Loại Chi "+ loaiChi.getTenLoaiChi() +" này không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LoaiChiFragment.loaiChiDelete(loaiChi.getId());
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        holder.imgEdtLoaiChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoaiChiFragment.loaiChiEdit(mContext, loaiChi.getId(), loaiChi.getTenLoaiChi());
            }
        });
    }

    @Override
    public int getItemCount() {
        return loaiChis.size();
    }
}
