/*
 *@author:<Wallace Moura Machado de Oliveira;1110482413004>
 */

package com.example.projectcpf;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText txtCpf;
    private EditText txtNome;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCpf = findViewById(R.id.txtCPF);
        txtNome = findViewById(R.id.txtNome);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(view -> {
                String cpf = txtCpf.getText().toString();
                String nome = txtNome.getText().toString();
                Pessoa pessoa = new Pessoa(cpf, nome);

                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                intent.putExtra("pessoa", pessoa);
                startActivity(intent);
        });
    }
}