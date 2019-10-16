package com.example.reyclerviewdialogvolley.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reyclerviewdialogvolley.R;
import com.example.reyclerviewdialogvolley.Usuarios;

import org.w3c.dom.Text;

import java.util.List;

public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.UsuariosHolder> {
    List<Usuarios> listaUsuarios;

    public UsuariosAdapter(List<Usuarios> listaUsuarios){
        this.listaUsuarios = listaUsuarios;

    }

    @NonNull
    @Override
    public UsuariosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        return new UsuariosHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosHolder holder, int position) {

        holder.txtName.setText(listaUsuarios.get(position).getFirstname().toString());
        holder.txtAge.setText(listaUsuarios.get(position).getAge().toString());
        holder.txtEmail.setText(listaUsuarios.get(position).getEmail().toString());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class UsuariosHolder extends RecyclerView.ViewHolder {

        TextView txtName,txtAge, txtEmail;

        public UsuariosHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtAge = itemView.findViewById(R.id.txt_age);
            txtEmail = itemView.findViewById(R.id.txt_email);
        }
    }
}
