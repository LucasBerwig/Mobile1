package br.ulbra.fuelsavier;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtNome, edtPlaca, edtDistancia, edtConsumo, edtPreco;
    Button btnCalculo;
    TextView txtR1, txtR2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtPlaca = findViewById(R.id.edtPlaca);
        edtDistancia = findViewById(R.id.edtDistancia);
        edtConsumo = findViewById(R.id.edtConsumo);
        edtPreco = findViewById(R.id.edtPreco);
        btnCalculo = findViewById(R.id.btnCalculo);
        txtR1 = findViewById(R.id.txtR1);
        txtR2 = findViewById(R.id.txtR2);

        btnCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valorA, valorB, valorC, result1, result2;
                try {
                    valorA = Double.parseDouble(edtDistancia.getText().toString());
                    valorB = Double.parseDouble(edtConsumo.getText().toString());
                    valorC = Double.parseDouble(edtPreco.getText().toString());
                    //Cálculo do consumo de combústivel//
                    result1 = valorA / valorB;
                    //cálculo do preço da viagem//
                    result2 = result1 * valorC;
                    //Resultados//
                    txtR1.setText("O combustível necessário é " + result1 + "L");
                    txtR2.setText("O preço total da viagem é " + result2 + "R$");

                } catch (NumberFormatException e) {
                    Toast.makeText(view.getContext(),
                            "Por favor, preencha ambos os campos corretamente", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}