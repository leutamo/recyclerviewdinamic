package com.example.reyclerviewdialogvolley;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.reyclerviewdialogvolley.adapter.UsuariosAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ConsultarListaUsuariosFragment extends DialogFragment implements Response.Listener<JSONObject>, Response.ErrorListener {

    RecyclerView recyclerView;
    ArrayList<Usuarios> listaUsuarios;

    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View vista = getActivity().getLayoutInflater().inflate(R.layout.fragment_layout, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        listaUsuarios = new ArrayList<>();

        recyclerView = vista.findViewById(R.id.recycler_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setHasFixedSize(true);

        requestQueue = Volley.newRequestQueue(getContext());

        cargarWebService();

        builder.setView(vista);
        builder.setMessage("Message!")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Clicked 'Okay'
                    }
                })
                .setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Clicked 'Cancel'
                    }
                });


        return builder.create();
    }

    private void cargarWebService() {
        String url = "http://myjson.com/qghaa";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        requestQueue.add(jsonObjectRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "Error" + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Usuarios usuario = null;
        try {
        JSONArray jsonArray = response.optJSONArray("employees");

             for (int i = 0; i< jsonArray.length();i++){
            usuario = new Usuarios();
            JSONObject jsonObject = null;
            jsonObject= jsonArray.getJSONObject(i);

            usuario.setFirstname(jsonObject.optString("firstname").toString());
            usuario.setAge(jsonObject.optString("age").toString());
            usuario.setEmail(jsonObject.optString("email").toString());

            listaUsuarios.add(usuario);

            }

            UsuariosAdapter adapter = new UsuariosAdapter(listaUsuarios);
             recyclerView.setAdapter(adapter);

        }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        }



    }
}
