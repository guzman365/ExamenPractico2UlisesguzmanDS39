package com.example.examenpractico2ulisesguzmands39;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {com.example.examenpractico2ulisesguzmands39.Empleado.class},version=1)
public abstract class AppDataBase extends RoomDatabase{
    public abstract com.example.examenpractico2ulisesguzmands39.EmpleadoDAO empleadoDAO();
}
