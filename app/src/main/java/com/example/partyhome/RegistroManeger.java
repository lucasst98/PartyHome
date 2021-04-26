package com.example.partyhome;
import java.util.ArrayList;

public class RegistroManeger {

    private static ArrayList <Registro> aRegistros = null;
    public static ArrayList<Registro> getaRegistros(){
     if(aRegistros == null )
         aRegistros = new ArrayList<Registro>();
     return aRegistros;
    }
}
