package Organizaciones;

import OperacionEgreso.OpEgreso;

public class Organizacion {

    private double gastos;
    private String nombre;
    private Integer identifiacion;
    private String direccion;

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdentifiacion() {
        return identifiacion;
    }

    public void setIdentifiacion(Integer identifiacion) {
        this.identifiacion = identifiacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void gastar(OpEgreso x){
        this.setGastos(this.getGastos() + x.getValorTotal());

    }
}
