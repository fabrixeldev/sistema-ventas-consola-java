package dao;

import modelo.Comprobante;
import modelo.Venta;

import java.util.ArrayList;

public class ComprobanteDao {

    private Comprobante comprobante;
    private Venta venta;

    ArrayList<Comprobante> listaComprobante = new ArrayList<>();

    public void agregarComprobante (int comprobId, String comprobCodigo, String comprobTipo, String comoprobSerie, boolean comprobEstado, Venta venta){
        Comprobante nuevoComprobante = new Comprobante(comprobId, comprobCodigo, comprobTipo, comoprobSerie, comprobEstado, venta);
        listaComprobante.add(nuevoComprobante);
        System.out.println("Se registro el comprobante: " + nuevoComprobante.getComprobCodigo());
    }

    public void listarComprobante (){
        if (listaComprobante.size() != 0){
            System.out.println(listaComprobante);
        }else{
            System.out.println("No existen datos para mostrar");
        }
    }

    public void editarComprobante (int comprobId, String comprobCodigo, String comprobTipo, String comprobSerie, boolean comprobEstado, Venta venta){
        for (Comprobante comprobante : listaComprobante){
            if (comprobante.getComprobId() == comprobId){
                if (!comprobCodigo.equals("")){
                    comprobante.setComprobCodigo(comprobCodigo);
                }
                if (!comprobTipo.equals("")){
                    comprobante.setComprobTipo(comprobTipo);
                }
                if (!comprobSerie.equals("")){
                    comprobante.setComprobSerie(comprobSerie);
                }
                if ((comprobEstado != true) || (comprobEstado != false)){
                    comprobante.setComprobEstado(comprobEstado);
                }
                if (venta != null){
                    comprobante.setVenta(venta);
                }
            }
        }
    }

    public void eliminarComprobante(int comprobId){
        listaComprobante.remove(comprobId);
        System.out.println("Se elimino el comprobante: " + comprobId);
    }
}
