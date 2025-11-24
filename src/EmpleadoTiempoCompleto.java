public class EmpleadoTiempoCompleto extends Empleado{
    private double sueldoBase,bono;

    public EmpleadoTiempoCompleto(){
        super();
    }

    @Override
    public void pedirDatos() throws Excepcion {
        super.pedirDatos();
        System.out.print("Ingrese el sueldo base: $");
        setSueldoBase(datos.nextDouble());
        System.out.print("Ingrese el bono: $");
        setBono(datos.nextDouble());
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) throws Excepcion {
        datos.nextLine();
        if (sueldoBase>0) {
            this.sueldoBase = sueldoBase;
        }else{
            throw new Excepcion("El sueldo debe ser mayor a $0.00");
        }
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) throws Excepcion {
        datos.nextLine();
        if (bono<0){
            throw new Excepcion("El bono no puede ser menor a $0.00");
        }else {
            this.bono = bono;
        }
    }

    @Override
    public void calcularSueldo() {
        double sueldo=sueldoBase+bono;
        setSueldo(sueldo);
    }

    @Override
    public void mostrarInformcaion() {
        super.mostrarInformcaion();
        System.out.print("\nSueldo Base: $"+sueldoBase+"\nBono: $"+bono+"\nSueldo Mensual: $"+getSueldo());
    }
}
