import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static Scanner datos=new Scanner(System.in);
    public static void menu(){
        do {
            try {
                System.out.println("\n--------- MENU PRINCIPAL ---------\n");
                System.out.print("1. Registrar empleado de Tiempo Completo\n2. Registrar mpleado de Medio Tiempo\n3. Ver Empleados\n4. Mostrar Estadisticas\n5. Salir\nIngrese una opcion: ");
                int opcionMenu = datos.nextInt();
                datos.nextLine();
                switch (opcionMenu){
                    case 1:
                        Empleado etc=new EmpleadoTiempoCompleto();
                        etc.pedirDatos();
                        Empleado.listaEmpleados.add(etc);
                        etc.calcularSueldo();
                        break;
                    case 2:
                        Empleado emt=new EmpleadoMedioTiempo();
                        emt.pedirDatos();
                        Empleado.listaEmpleados.add(emt);
                        emt.calcularSueldo();
                        break;
                    case 3:
                        if (Empleado.listaEmpleados.isEmpty()){
                            System.out.println("No hay registros");
                            break;
                        }
                        System.out.println("### EMPLEADOS A TIEMPO COMPLETO ###");
                        boolean tiempoCompleto=false;
                        for(Empleado e : Empleado.listaEmpleados){
                            if (e instanceof EmpleadoTiempoCompleto) {
                                e.mostrarInformcaion();
                                System.out.println("\n");
                                tiempoCompleto=true;
                            }
                        }
                        if (!tiempoCompleto){
                            System.out.println("No hay empleados a tiempo completo");
                        }
                        System.out.println("### EMPLEADOS DE MEDIO TIEMPO ###");
                        boolean medioTiempo=false;
                        for(Empleado e : Empleado.listaEmpleados){
                            if (e instanceof EmpleadoMedioTiempo) {
                                e.mostrarInformcaion();
                                medioTiempo=true;
                            }
                        }
                        if (!medioTiempo){
                            System.out.println("No hay empleados a tiempo completo");
                        }
                        break;
                    case 4:
                        if (Empleado.listaEmpleados.isEmpty()){
                            System.out.println("No hay registros");
                            break;
                        }
                        System.out.println("### ESTADISTICAS EMPRESA ###");
                        Empleado base=Empleado.listaEmpleados.get(0);
                        double sumaSueldos=0;
                        for (int i = 0; i < Empleado.listaEmpleados.size(); i++) {
                            Empleado arreglo=Empleado.listaEmpleados.get(i);
                            if (base.getSueldo()<arreglo.getSueldo()){
                                base=arreglo;
                            }
                            sumaSueldos+=Empleado.listaEmpleados.get(i).getSueldo();
                        }

                        double promedioSuledos=sumaSueldos/Empleado.listaEmpleados.size();

                        System.out.println("El empleado con mayor sueldo es: "+base.getNombre()+" "+base.getApellido()+" con $"+base.getSueldo()+" mensuales");
                        System.out.println("El promedio de sueldos es: $"+promedioSuledos);
                        break;
                    case 5:
                        System.out.println("Saliendo....");
                        return;
                    default:
                        System.out.println("Opcion Inválida");
                        break;
                }
            }catch (InputMismatchException e){
                System.err.println("Ingresaste una letra en un valor numerico. Presiona ENTER para continuar");
                datos.nextLine();
            }catch (Excepcion e){
                System.err.println(e.getMessage());
            }
        }while (true);
    }
    public static void main(String[] args){
        menu();
    }
}