public class Control79 {
    public static void main(String[] args) {
        System.out.print("Ingrese cantidad de autores a procesar: ");
        int cantAutores = Integer.parseInt(System.console().readLine());
        int a = 1;

        int totalLibrosGeneral = 0;
        int librosCienciaFiccion = 0;
        int librosRomance = 0;

        int maxLibrosAutor = -1;
        String autorMaxLibros = "";

        if (cantAutores > 0) {
            while (a <= cantAutores) {
                System.out.println("\n--- Autor #" + a + " ---");
                System.out.print("Apellido del autor: ");
                String apellido = System.console().readLine();
                System.out.print("Cantidad de libros del autor: ");
                int cantLibros = Integer.parseInt(System.console().readLine());

                int totalPaginasAutor = 0;
                int maxPaginasLibro = -1;
                String codLibroMayorPaginas = "";

                int l = 1;
                if (cantLibros > 0) {
                    while (l <= cantLibros) {
                        System.out.print("  Libro #" + l + " - Codigo: ");
                        String codLibro = System.console().readLine();
                        System.out.print("  Libro #" + l + " - Genero (1=CienciaFiccion, 2=Romance, 3=Accion, 4=Terror, 5=Novela, 6=Autoayuda, 7=Academico): ");
                        int gen = Integer.parseInt(System.console().readLine());
                        System.out.print("  Libro #" + l + " - Numero de paginas: ");
                        int paginas = Integer.parseInt(System.console().readLine());

                        totalPaginasAutor += paginas;
                        totalLibrosGeneral++;

                        if (gen == 1) {
                            librosCienciaFiccion++;
                        } else if (gen == 2) {
                            librosRomance++;
                        }

                        if (l == 1 || paginas > maxPaginasLibro) {
                            maxPaginasLibro = paginas;
                            codLibroMayorPaginas = codLibro;
                        }

                        l++;
                    }
                }

                System.out.println("\nReporte por Autor:");
                System.out.println("Apellido: " + apellido);
                System.out.println("Total paginas escritas: " + totalPaginasAutor);
                System.out.println("Libro con mayor numero de paginas: Codigo " + codLibroMayorPaginas + " (" + maxPaginasLibro + " paginas)");

                if (a == 1 || cantLibros > maxLibrosAutor) {
                    maxLibrosAutor = cantLibros;
                    autorMaxLibros = apellido;
                }

                a++;
            }
        }

        System.out.println("\n==========================================");
        System.out.println("--- ESTADISTICAS GENERALES DE LA LIBRERIA ---");
        if (totalLibrosGeneral > 0) {
            double porcCF = ((double) librosCienciaFiccion / totalLibrosGeneral) * 100.0;
            System.out.printf("Porcentaje de libros de ciencia ficcion: %.2f%%%n", porcCF);
        }
        System.out.println("Cantidad de libros de ciencia ficcion en existencia: " + librosCienciaFiccion);
        System.out.println("Cantidad de libros de romance en existencia: " + librosRomance);
        System.out.println("Autor con mayor cantidad de libros: " + autorMaxLibros + " (" + maxLibrosAutor + " libros)");
    }
}
