/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriamenu;

import java.util.Scanner;

/**
 *
 * @author a20armandocb
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean continuar = true;
        Scanner lector = new Scanner(System.in);
        Menu menu = construirMenuPrincipal(lector);
        do {
            try {
                continuar = menuAcciones(menu);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } while (continuar);

        lector.close();
    }

    private static Menu construirMenuPrincipal(Scanner lector) {
        Menu menu = new Menu(lector);
        menu.setTituloMenu("Menú de Ejemplo");
        menu.setTexoSalir("Adios");
        
        menu.addOpcion("Opcion 1",() -> { 
                                            // metodos a ejecutar
                                            System.out.println("Opcion 1");
                                        });
        
        menu.addOpcion("Opcion 2",() -> { 
                                            // metodos a ejecutar
                                            System.out.println("Opcion 2");
                                        });
        
        menu.addOpcion("Opcion 3",() -> { 
                                            // metodos a ejecutar
                                            System.out.println("Opcion 3");
                                        });

        return menu;
    }

    private static boolean menuAcciones(Menu menu) throws Exception {
        boolean continuar = true;
        menu.mostrarGUI();
        //menu.mostrar();
        switch (menu.getSeleccion()) {
            case 0:
                //salir
                continuar = false;
                System.out.println("Bye Bye!");
                break;
                //deprecated
//            case 1:
//                System.out.println(EntradasGui.pedirFecha("mensaje").toString());
//                break;
//            case 2:
//                System.out.println("Ha seleccionado la opción 2");
//                break;
//            case 3:
//                System.out.println("Ha seleccionado la opción 3");
//                break;
//            case 4:
//                System.out.println("Ha seleccionado la opción 4");
//                break;
//            case 5:
//                System.out.println("Ha seleccionado la opción 5");
//                break;
//            case 6:
//                System.out.println("Ha seleccionado la opción 6");
//                break;
//            default:
//                System.out.println("opcion incorrecta");
//                break;

        }
        return continuar;
    }
}
