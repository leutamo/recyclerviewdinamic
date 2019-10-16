package com.example.reyclerviewdialogvolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_selecciona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_selecciona = findViewById(R.id.btn_selecciona);
        final FragmentManager fm = getSupportFragmentManager();
        final ConsultarListaUsuariosFragment ls = new ConsultarListaUsuariosFragment();

        btn_selecciona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ls.show(fm,"LS_Tag");
            }
        });
    }
}
