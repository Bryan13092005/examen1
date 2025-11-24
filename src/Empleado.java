import java.util.ArrayList;
import java.util.Scanner;

public abstract class Empleado {
    private String codigo, nombre, apellido, cargo;
    public static ArrayList<Empleado> listaEmpleados=new ArrayList<>();
    private double sueldo;
    public Empleado(){}
    public static Scanner datos =new Scanner(System.in);

    public void pedirDatos() throws Excepcion {
        System.out.print("Codigo: ");
        setCodigo(datos.nextLine());
        System.out.print("Nombre: ");
        setNombre(datos.nextLine());
        System.out.print("Apelldo: ");
        setApellido(datos.nextLine());
        System.out.print("Cargo: ");
        setCargo(datos.nextLine());
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws Excepcion {
        if (codigo.trim().isEmpty()){
            throw new Excepcion("Codigo vacio");
        }else {
            if (listaEmpleados.isEmpty()) {
                this.codigo = codigo;
            }else{
                for(Empleado e:listaEmpleados){
                    if (e.getCodigo().equals(codigo)){
                        throw new Excepcion("El codigo debe ser unico. \nYa existe un empleado con ese codigo");
                    }else{
                        this.codigo=codigo;
                    }
                }
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Excepcion {
        if (nombre.trim().isEmpty()){
            throw new Excepcion("El nombre no debe estar vacio");
        }else {
            this.nombre = nombre.toUpperCase();
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws Excepcion {
        if (apellido.trim().isEmpty()){
            throw new Excepcion("El apellido no debe estar vacio");
        }else {
            this.apellido = apellido.toUpperCase();
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) throws Excepcion {
        if (cargo.trim().isEmpty()){
            throw new Excepcion("El cargo no debe estar vacio");
        }else {
            this.cargo = cargo.toUpperCase();
        }
    }

    public void mostrarInformcaion(){
        System.out.print("Codigo=" + codigo +
                "\nNombre=" + nombre +
                "\nApellido=" + apellido +
                "\nCargo=" + cargo);
    }

    public double getSueldo() {
            return sueldo;
    }

    public void setSueldo(double sueldo){
        this.sueldo=sueldo;
    };

    public abstract void calcularSueldo();
}
