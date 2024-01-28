package com.project;

import java.io.File;

import java.util.Collection;
import java.util.HashSet;

/*

Help: https://www.baeldung.com/hibernate-one-to-many

*/

public class Main {

   public static void main(String[] args) {
      
      String basePath = System.getProperty("user.dir") + "/data/";

      // Crear la carpeta 'data' si no existeix
      File dir = new File(basePath);
      if (!dir.exists()){
         if(!dir.mkdirs()) {
               System.out.println("Error en la creació de la carpeta 'data'");
         }
      }

     Manager.createSessionFactory();


         Manager.createSessionFactory();


// Afegir llibres


Llibre lib00 = Manager.addEntity("LL00B0", "Editorial 0");
Llibre lib01 = Manager.addLlibre("LL01B0", "Editorial 1");
Llibre lib02 = Manager.addLlibre("LL02B0", "Editorial 2");
Llibre lib03 = Manager.addLlibre("LL03B0", "Editorial 3");
Llibre lib04 = Manager.addLlibre("LL04B0", "Editorial 4");


Llibre lib05 = Manager.addLlibre("LL00B1", "Editorial 0");
Llibre lib06 = Manager.addLlibre("LL01B1", "Editorial 1");
Llibre lib07 = Manager.addLlibre("LL02B1", "Editorial 2");
Llibre lib08 = Manager.addLlibre("LL03B1", "Editorial 3");
Llibre lib09 = Manager.addLlibre("LL04B1", "Editorial 4");


Llibre lib10 = Manager.addLlibre("LL00B2", "Editorial 0");
Llibre lib11 = Manager.addLlibre("LL01B2", "Editorial 1");
Llibre lib12 = Manager.addLlibre("LL02B2", "Editorial 2");
Llibre lib13 = Manager.addLlibre("LL03B2", "Editorial 3");
Llibre lib14 = Manager.addLlibre("LL04B2", "Editorial 4");


// Afegir biblioteques


Biblioteca bib0 = Manager.addBiblioteca("Biblio 0", "Ciutat 0");
Set<Llibre> llibresBib0 = new HashSet<Llibre>();
llibresBib0.add(lib00);
llibresBib0.add(lib01);
llibresBib0.add(lib02);
llibresBib0.add(lib03);
llibresBib0.add(lib04);
Manager.updateBiblioteca(bib0.getBibliotecaId(), 
    bib0.getNom(), bib0.getCiutat(), llibresBib0);


Biblioteca bib1 = Manager.addBiblioteca("Biblio 1", "Ciutat 1");
Set<Llibre> llibresBib1 = new HashSet<Llibre>();
llibresBib1.add(lib05);
llibresBib1.add(lib06);
llibresBib1.add(lib07);
llibresBib1.add(lib08);
llibresBib1.add(lib09);
Manager.updateBiblioteca(bib1.getBibliotecaId(), 
    bib1.getNom(), bib1.getCiutat(), llibresBib1);


Biblioteca bib2 = Manager.addBiblioteca("Biblio 2", "Ciutat 2");
Set<Llibre> llibresBib2 = new HashSet<Llibre>();
llibresBib2.add(lib10);
llibresBib2.add(lib11);
llibresBib2.add(lib12);
llibresBib2.add(lib13);

         }


         Manager.delete(Ciutada.class, pep1.getId());
         Manager.delete(Ciutada.class, pep3.getId());
         Manager.delete(Ciutada.class, pep5.getId());
         Manager.delete(Ciutat.class, ciu1.getCiutatId());


         System.out.println("Ciutats:");
         Collection<?> llista = Manager.listCollection(Ciutat.class, "");
         for(Object obj: ciutats) {
            Ciutat cObj = (Ciutat) obj;
            System.out.println("  " + cObj);
         }
         System.out.println("Ciutadans:");
         llista = Manager.listCollection(Ciutada.class, "");
         for(Object obj: llista) {
            Ciutada cObj = (Ciutada) obj;
            System.out.println("  " + cObj);
         }


         Manager.close();

            }
}