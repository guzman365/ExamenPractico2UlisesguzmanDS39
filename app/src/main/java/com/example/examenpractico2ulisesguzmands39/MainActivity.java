package com.example.examenpractico2ulisesguzmands39;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtNombre, edtDui, edtTelefono, edtDepartamento;
    TextView txvConsulta;
    Button btnGuardar, btnConsultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNombre = findViewById(R.id.edtNombre);
        edtDui = findViewById(R.id.edtDui);
        edtTelefono = findViewById(R.id.edtTelefono);
        edtDepartamento = findViewById(R.id.edtDepartamento);
        txvConsulta = findViewById(R.id.txvConsulta);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnConsultar = findViewById(R.id.btnConsultar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataBase db = Room.databaseBuilder(
                        MainActivity.this,
                        AppDataBase.class,
                        "dbempleados").allowMainThreadQueries().build();
                Empleado empleado = new Empleado(
                        edtNombre.getText().toString(),
                        edtDui.getText().toString(),
                        edtTelefono.getText().toString(),
                        edtDepartamento.getText().toString()
                );
                edtNombre.setText("");
                edtDui.setText("");
                edtTelefono.setText("");
                edtDepartamento.setText("");
                Long reg = db.empleadoDAO().insert(empleado);
                Toast.makeText(
                        getApplicationContext(),
                        "Registro almacenado correctamente",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataBase db = Room.databaseBuilder(
                        MainActivity.this,
                        AppDataBase.class,
                        "dbempleados").allowMainThreadQueries().build();
                List<Empleado> lista = db.empleadoDAO().getAll();

                String valores = "";

                for(int i=0;i<lista.size();i++){
                    valores += lista.get(i).nombre + " "
                            + lista.get(i).dui + " "
                            + lista.get(i).telefono + " "
                            + lista.get(i).departamento
                            +"\n";
                }//Fin FOR

                txvConsulta.setText(valores);
            }
        });
    }
}