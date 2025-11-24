public class EmpleadoMedioTiempo extends Empleado{
    private int horas;
    private double pagoPorHora;

    public EmpleadoMedioTiempo(){
        super();
    }

    @Override
    public void pedirDatos() throws Excepcion {
        super.pedirDatos();
        System.out.print("Horas trabajadas: ");
        setHoras(datos.nextInt());
        System.out.print("Pago por hora: $");
        setPagoPorHora(datos.nextDouble());
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) throws Excepcion {
        datos.nextLine();
        if (horas<=0){
            throw new Excepcion("Las horas no pueden ser menores o iguales a 0");
        }else {
            this.horas = horas;
        }
    }

    public double getPagoPorHora() {
        return pagoPorHora;
    }

    public void setPagoPorHora(double pagoPorHora) throws Excepcion {
        datos.nextLine();
        if (pagoPorHora<=0){
            throw new Excepcion("El  pago por hroa debe ser mayor a $0.00");
        }else {
            this.pagoPorHora = pagoPorHora;
        }
    }

    @Override
    public void calcularSueldo() {
        double sueldo=(horas*pagoPorHora);
        setSueldo(sueldo);
    }

    @Override
    public void mostrarInformcaion() {
        super.mostrarInformcaion();
        System.out.print("\nHoras trabajadas: "+horas+"h\nPago por hora: $"+pagoPorHora+"\nSueldo Mensual: $"+getSueldo());
    }
}
