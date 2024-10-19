package com.example.projectcpf;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {
    private TextView lblResultado;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        lblResultado = findViewById(R.id.lblResultado);
        btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        Pessoa pessoa = (Pessoa) intent.getSerializableExtra("pessoa");

        String localRegistro = determinarLocalRegistro(pessoa.getCpf());

        lblResultado.setText("Nome: " + pessoa.getNome() + "\nLocal de registro: " + localRegistro);

        btnVoltar.setOnClickListener(view -> {
                Intent intent1 = new Intent(ResultadoActivity.this, MainActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);
        });
    }

    private String determinarLocalRegistro(String cpf) {
        String cpfNumeros = cpf.replaceAll("\\D", "");
        if (cpfNumeros.length() < 9) {
            return "CPF inválido";
        }
        char nonoDigito = cpfNumeros.charAt(8);
        String local;
        switch(nonoDigito) {
            case '1':
                local = "Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul e Tocantins";
                break;
            case '2':
                local = "Pará, Amazonas, Acre, Amapá, Rondônia e Roraima";
                break;
            case '3':
                local = "Ceará, Maranhão e Piauí";
                break;
            case '4':
                local = "Pernambuco, Rio Grande do Norte, Paraíba e Alagoas";
                break;
            case '5':
                local = "Bahia e Sergipe";
                break;
            case '6':
                local = "Minas Gerais";
                break;
            case '7':
                local = "Rio de Janeiro e Espírito Santo";
                break;
            case '8':
                local = "São Paulo";
                break;
            case '9':
                local = "Paraná e Santa Catarina";
                break;
            case '0':
                local = "Rio Grande do Sul";
                break;
            default:
                local = "Local desconhecido";
        }
        return local;
    }
}