package com.example.examenpractico2ulisesguzmands39;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Empleado {
    @PrimaryKey(autoGenerate = true)
    int empleadoid;
    @ColumnInfo(name = "nombre")
    String nombre;
    @ColumnInfo(name = "dui")
    String dui;
    @ColumnInfo(name = "telefono")
    String telefono;
    @ColumnInfo(name = "departamento")
    String departamento;

    public Empleado(String nombre, String dui, String telefono, String departamento) {
        this.nombre = nombre;
        this.dui = dui;
        this.telefono = telefono;
        this.departamento = departamento;
    }

    public int getEmpleadoid() {
        return empleadoid;
    }

    public void setEmpleadoid(int empleadoid) {
        this.empleadoid = empleadoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
