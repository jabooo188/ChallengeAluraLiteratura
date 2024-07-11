package com.aluracurso.challengeliteratura.principal;

import com.aluracurso.challengeliteratura.service.ConsumoAPI;

import java.util.Scanner;

public class Principal {
    Scanner teclado = new Scanner(System.in);
    //ConsumoAPI consumoAPI = new ConsumoAPI();
    //consumoAPI.obtenerDatos();

    public void menu (){
        var opcion = 1;
        while (opcion != 0){
            var menu = """
                    <---------------------------------------------------->
                    Elije una opción del menú
                    
                    1) Buscar libro por titulo
                    2) Libros registrados
                    3) Autores registrados
                    4) Autores vivos en determinado año
                    5) Libros por idioma
                    
                    
                    8) Salir
                    <---------------------------------------------------->
         
                    """;
            //System.out.println(menu);
        }
    }

}
