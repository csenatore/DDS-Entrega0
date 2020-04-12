package OperacionEgreso;

import Organizaciones.Organizacion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Arrays;
import Items.Item;
import Documentos.DocumentoComercial;
import MediosDePago.Medio;
import Documentos.Remito;


public class OpEgreso {

    private Date fecha;
    private double valorTotal;
    private Organizacion org;
    private ArrayList<Item> items = new ArrayList<>();
    private DocumentoComercial comprobante = null;
    private Medio medio;
    private boolean operacionCerrada = false;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setValorTotal(double valorTotal) throws OpCerradaException {
        if(this.operacionCerrada){
            throw new OpCerradaException("No se puede modificar el valor cuando la operacion se encuentra cerrada");
        }
        this.valorTotal = valorTotal;
    }

    public Organizacion getOrg() {
        return org;
    }

    public void setOrg(Organizacion org) {
        this.org = org;
    }

    public DocumentoComercial getComprobante() {
        return comprobante;
    }

    public void setComprobante(DocumentoComercial comprobante) {
        this.comprobante = comprobante;
    }

    public Medio getMedio() {
        return medio;
    }

    public void setMedio(Medio medio) {
        this.medio = medio;
    }
    public boolean isOperacionCerrada() {
        return operacionCerrada;
    }

    public void setOperacionCerrada(boolean operacionCerrada) {
        this.operacionCerrada = operacionCerrada;
    }


    public void cerrarOperacion(){
        this.setOperacionCerrada(true);
    }

    public void calcularValor() throws OpCerradaException {
        double total = 0;
        for(int x = 0; x < items.size(); x++){
            total += items.get(x).getValorTotal();
        }
        this.setValorTotal(total);
    }

    public DocumentoComercial generarRemito(Integer numeroDoc) {
        DocumentoComercial doc = new Remito(numeroDoc);

        return doc;
    }

    public void efecturarOperacion(Integer num) throws OpCerradaException, OperacionInvalidaException {
        if(this.items.size()< 1){
            throw new OperacionInvalidaException("La operacion de egreso no tiene items asociados");
        }
        this.calcularValor();
        this.cerrarOperacion();
        boolean sonTodosArticulos = (this.getItems()).stream().allMatch(val -> val.generaRemito());
        if(sonTodosArticulos){

             this.setComprobante(this.generarRemito(num));

        }
    }

}
