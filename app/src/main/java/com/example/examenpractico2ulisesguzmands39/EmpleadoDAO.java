package com.example.examenpractico2ulisesguzmands39;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EmpleadoDAO {

    @Query("SELECT * FROM Empleado")
    List<Empleado> getAll();

    @Query("SELECT * FROM Empleado WHERE dui LIKE :dui LIMIT 1")
    Empleado findbyDui(String dui);

    @Insert
    Long insert(Empleado empleado);
}
