package com.andrea.floodwarning;

/**
 * Created by Acer on 11-02-2017.
 */

public class Registro {

    private String rio;
    private String telefono;

    public Registro(String rio, String telefono) {
        this.rio = rio;
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRio() {
        return rio;
    }

    public void setRio(String rio) {
        this.rio = rio;
    }
}

