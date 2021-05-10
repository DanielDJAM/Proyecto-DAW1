package es.iespuertolacruz.developers.api;

public class Tarjeta extends MetodoPago {

    String fechaCaducidad;
    int cvv;

    public Tarjeta(String titular, String numeroCuenta, String fechaCaducidad,int cvv) {
        super(titular, numeroCuenta);
        this.fechaCaducidad = fechaCaducidad;
        this.cvv = cvv;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return getTitular() + getNumeroCuenta() + getFechaCaducidad() + getCvv();
    }

    
    
    

   
}
