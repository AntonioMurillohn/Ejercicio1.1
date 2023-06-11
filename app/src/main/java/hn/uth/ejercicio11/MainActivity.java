package hn.uth.ejercicio11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText editTextNumero1,editTextNumero2;

    Button btnSumar,btnRestar,btnDividir,btnMultiplicar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSumar = (Button) findViewById(R.id.btnsumar);
        btnRestar = (Button) findViewById(R.id.btnrestar);
        btnMultiplicar = (Button) findViewById(R.id.btndividir);
        btnDividir = (Button) findViewById(R.id.btnmultiplicar);
        editTextNumero1 =(EditText) findViewById(R.id.num1);
        editTextNumero2 =(EditText) findViewById(R.id.num2);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double resultado = obtenerNumero1() + obtenerNumero2();
                mostrarResultado(resultado);
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double resultado = obtenerNumero1() - obtenerNumero2();
                mostrarResultado(resultado);
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double resultado = obtenerNumero1() * obtenerNumero2();
                mostrarResultado(resultado);
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double numero2 = obtenerNumero2();
                if (numero2 == 0) {
                    Toast.makeText(MainActivity.this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                } else {
                    double resultado = obtenerNumero1() / numero2;
                    mostrarResultado(resultado);
                }
            }
        });
    }

    private double obtenerNumero1() {
        String numero1String = editTextNumero1.getText().toString();
        if (numero1String.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(numero1String);
    }

    private double obtenerNumero2() {
        String numero2String = editTextNumero2.getText().toString();
        if (numero2String.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(numero2String);
    }

    private void mostrarResultado(double resultado) {
        Toast.makeText(MainActivity.this, "El resultado es: " + resultado, Toast.LENGTH_SHORT).show();
    }
}