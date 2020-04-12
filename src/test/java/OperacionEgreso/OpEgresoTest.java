package OperacionEgreso;
import org.junit.Test;
import junit.framework.AssertionFailedError;
import org.junit.Assert;
import Items.*;
import OperacionEgreso.*;
import Documentos.*;

import java.util.ArrayList;
import java.util.Date;

public class OpEgresoTest {

   @Test
    public void testCambiarPrecioOK() throws OpCerradaException, OperacionInvalidaException {
       //Precondicion

      //Crear opEgreso e Items

    Item correa = new Articulo(100, "Correa de perro");
    Item cucha = new Articulo(500, "Cucha para perro");
    Item paseo = new Servicio(200, "Paseador de perros");
    ArrayList<Item> items = new ArrayList<Item>();
    items.add(correa);
    items.add(cucha);
    items.add(paseo);


    OpEgreso operacion = new OpEgreso();
    operacion.setItems(items);
    operacion.setFecha(new Date(2020, 04, 11));

      //Accion Cambiar precio de algun item

    correa.setValorTotal(150);

    //Efectuar operacion

      operacion.efecturarOperacion(1);

      //Validar $850
      Assert.assertEquals(850.0, operacion.getValorTotal(),0 );
      Assert.assertTrue(operacion.isOperacionCerrada());

   }
    @Test(expected = OperacionInvalidaException.class)
    public void testOperacionSinItems() throws OpCerradaException, OperacionInvalidaException {
     //Precondicion


     OpEgreso operacion = new OpEgreso();
     operacion.setFecha(new Date(2020, 04, 11));

     //Accion
     operacion.efecturarOperacion(2);


    }
    @Test(expected=OpCerradaException.class)
    public void testCambiarPrecioOpCerrada() throws OpCerradaException, OperacionInvalidaException {
     //Precondicion

     Item correa = new Articulo(100, "Correa de perro");
     Item cucha = new Articulo(500, "Cucha para perro");
     Item paseo = new Servicio(200, "Paseador de perros");
     ArrayList<Item> items = new ArrayList<Item>();
     items.add(correa);
     items.add(cucha);
     items.add(paseo);


     OpEgreso operacion = new OpEgreso();
     operacion.setItems(items);
     operacion.setFecha(new Date(2020, 04, 11));

     //Efectuar operacion

     operacion.efecturarOperacion(3);

     //Accion Cambiar precio de algun item

 correa.setValorTotal(99);
 operacion.efecturarOperacion(3);

    }
    @Test
    public void testGenerarRemitoOK() throws OpCerradaException, OperacionInvalidaException {
     //Precondicion

     Item correa = new Articulo(100, "Correa de perro");
     Item cucha = new Articulo(500, "Cucha para perro");
     ArrayList<Item> items = new ArrayList<Item>();
     items.add(correa);
     items.add(cucha);

     OpEgreso operacion = new OpEgreso();
     operacion.setItems(items);
     operacion.setFecha(new Date(2020, 04, 11));

     //Accion

     operacion.efecturarOperacion(4);
     DocumentoComercial remito = operacion.getComprobante();
     //Validar
     Assert.assertTrue(operacion.getComprobante()!= null);
     Assert.assertEquals(4, remito.getNumero(),0);

    }
    @Test
    public void testNoGenerarRemito() throws OpCerradaException, OperacionInvalidaException {
     //Precondicion

     Item correa = new Articulo(100, "Correa de perro");
     Item cucha = new Articulo(500, "Cucha para perro");
     Item paseo = new Servicio(200, "Paseador de perros");
     ArrayList<Item> items = new ArrayList<Item>();
     items.add(correa);
     items.add(cucha);
     items.add(paseo);


     OpEgreso operacion = new OpEgreso();
     operacion.setItems(items);
     operacion.setFecha(new Date(2020, 04, 11));

     //Accion

     operacion.efecturarOperacion(5);

     //Validar
     Assert.assertTrue(operacion.getComprobante() == null);

    }
}

