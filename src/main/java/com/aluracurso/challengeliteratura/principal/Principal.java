package com.aluracurso.challengeliteratura.principal;

import com.aluracurso.challengeliteratura.model.Autores;
import com.aluracurso.challengeliteratura.model.DatosLibro;
import com.aluracurso.challengeliteratura.model.Libro;
import com.aluracurso.challengeliteratura.model.ResultadoAPIBusqueda;
import com.aluracurso.challengeliteratura.repository.AutoresRepository;
import com.aluracurso.challengeliteratura.repository.LibroRepository;
import com.aluracurso.challengeliteratura.service.ConsumoAPI;
import com.aluracurso.challengeliteratura.service.ConvertirDatosLibro;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvertirDatosLibro convertirDatos = new ConvertirDatosLibro();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private LibroRepository libroRepository;
    private AutoresRepository autoresRepository;
    private List<Libro> datosLibro = new ArrayList<>();

    public Principal(LibroRepository libroRepository, AutoresRepository autoresRepository){
        this.libroRepository = libroRepository;
        this.autoresRepository = autoresRepository;
    }



    public void menu (){
        var opcion = 1;
        while (opcion != 8){
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

            try {
                System.out.println(menu);
                opcion = teclado.nextInt();
                teclado.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Ingrese una opción válida \n");
            }

            switch (opcion){
                case 1:
                    buscarLibroEnAPI();
                    break;
                case 2:
                    librosRegistrados();
                    break;
                case 3:
                    autoresRegistrados();
                    break;
                case 4:
                    autoresVivos();
                    break;
                case 5:
                    librosPorIdioma();
                    break;
                case 8:
                    System.out.println("Cerrando Programa \n");
                    System.out.println("Gracias!!!!!!");
                    break;
                default:
                    System.out.println("Opción inválida \n");
                    menu();
                    break;
            }

        }
    }


    private Libro datosLibro (){
        System.out.println("Ingrsa el titulo del libro a buscar:");
        var libroTitulo = teclado.nextLine().toLowerCase();
        var json = consumoAPI.obtenerDatos(URL_BASE+libroTitulo.replace(" ", "%20"));
        ResultadoAPIBusqueda datos = convertirDatos.convertirDatosJson(json, ResultadoAPIBusqueda.class);

        if (datos != null && datos.getResultado() != null && !datos.getResultado().isEmpty()){
            DatosLibro libroEncontrado = datos.getResultado().get(0);
            return new Libro(libroEncontrado);
        } else {
            System.out.println("Libro no encontrado");
            return null;
        }
    }

    private void buscarLibroEnAPI() {
        var libro = datosLibro();

        if (libro == null){
            System.out.println("Libro no encontrado");
            return;
        }

        try {
            boolean libroAlmacenado = libroRepository.existsByTitulo(libro.getTitulo());
            if (libroAlmacenado){
                System.out.println("Libro ya almacenado. Intenta con otro!! \n");
                buscarLibroEnAPI();
            } else {
                libroRepository.save(libro);
                System.out.println("Se agregó el libro: "+libro+"a nuestra base de datos!!");
            }
        }catch (InvalidDataAccessApiUsageException e){
            System.out.println("Libro ya almacenado. Intenta con otro!! \n");
        }

    }

    @Transactional(readOnly = true)
    private void librosRegistrados() {
        List<Libro> libros = libroRepository.findAll();
        if (libros.isEmpty()){
            System.out.println("No hay registros en la base de datos");
        } else {
            System.out.println("Encontre esto: \n");
            for (Libro libro : libros){
                System.out.println(libro.toString());
            }
        }
    }

    private void autoresRegistrados() {
        List<Autores> autoresList = autoresRepository.findAll();

        if (autoresList.isEmpty()){
            System.out.println("Sin registros");
        } else {
            System.out.println("Todos los autores en la Base de Datos");
            Set<String> autores = new HashSet<>();
            for (Autores autores1 : autoresList){
                if (autores.add(autores1.getNombre())){
                    System.out.println(autores1.getNombre());
                }
            }
        }
    }

    private void autoresVivos() {
        System.out.println("¿En qué año deaseas buscar autores con vida?");
        var year = teclado.nextInt();
        teclado.nextLine();

        List<Autores> autorVivo = autoresRepository
                .findByFechaNacimientoLessThanOrFechaMuerteGreaterThanEqual(year, year);

        if (autorVivo.isEmpty()){
            System.out.println("No se encontraron autores");
        } else {
            System.out.println("Los autores vivos en el año: "+year+"\n");
            Set<String> autoresYear = new HashSet<>();

            for (Autores autores : autorVivo){
                if (autores.getFechaNacimiento() != null && autores.getFechaMuerte() != null){
                    if (autores.getFechaNacimiento() <= year && autores.getFechaMuerte() >= year);{
                        if (autoresYear.add(autores.getNombre())){
                            System.out.println(autores.getNombre());
                        }
                    }
                }
            }
        }
    }

    private void librosPorIdioma() {
        var seleccionIdioma = """
                    <---------------------------------------------------->
                    Elije una opción del menú
                    
                    es - Español
                    en - Inglés
                    fr - Francés
                    pt - Portugués
                    
                    <---------------------------------------------------->
         
                    """;

        System.out.println(seleccionIdioma);
        var idioma = teclado.nextLine();
        List<Libro> idiomaLibro = libroRepository.findByIdioma(idioma);

        if (idiomaLibro.isEmpty()){
            System.out.println("Ningun libro en ese idioma");
            librosPorIdioma();
        } else {
            System.out.println("Aqui una lista de los libros en idioma: "+idiomaLibro+"\n");
            for (Libro libros : idiomaLibro){
                System.out.println(libros.toString());
            }
        }
    }

}
