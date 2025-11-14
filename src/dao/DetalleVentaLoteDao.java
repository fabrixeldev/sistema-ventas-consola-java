package dao;

import modelo.DetalleVenta;
import modelo.DetalleVentaLote;
import modelo.Lote;

import java.util.ArrayList;
import java.util.Optional;

public class DetalleVentaLoteDao {
    private Lote lote;
    private DetalleVenta detalleVenta;

    private ArrayList<DetalleVentaLote> listaDetalleVentaLote = new ArrayList<>();

    public void agregarDetalleVentaLote(int detVenLoteId, int detVentLoteCantidad, Lote lote, DetalleVenta detalleVenta){
        DetalleVentaLote nuevoDetalleVentaLote = new DetalleVentaLote(detVenLoteId, detVentLoteCantidad, lote, detalleVenta);
        listaDetalleVentaLote.add(nuevoDetalleVentaLote);
        System.out.println("Se registro el Detalle Venta Lote: " + nuevoDetalleVentaLote.getDetVenLoteId());
    }

    public void listarDetalleVentaLote(){
        if (listaDetalleVentaLote.size() != 0){
            System.out.println(listaDetalleVentaLote);
        }else{
            System.out.println("No existen datos para mostrar");
        }
    }

    public void editarDetalleVentaLote(int detVenLoteId, int detVentLoteCantidad, Lote lote, DetalleVenta detalleVenta){
        for (DetalleVentaLote detalleVentaLote: listaDetalleVentaLote){
            if (detalleVentaLote.getDetVenLoteId() == detVenLoteId){
                if (detVentLoteCantidad != 0){
                    detalleVentaLote.setDetVenLoteCantidad(detVentLoteCantidad);
                }
                if (lote != null){
                    detalleVentaLote.setLote(lote);
                }
                if (detalleVenta != null){
                    detalleVentaLote.setDetalleVenta(detalleVenta);
                }
            }
        }
    }

    public void eliminarDetalleVentaLote(int detVenLoteId){
        DetalleVentaLote encontrado = null;
        for (DetalleVentaLote dvl : listaDetalleVentaLote){
            if (dvl.getDetVenLoteId() == detVenLoteId){
                encontrado = dvl;
            }
        }

        if (encontrado != null){
            listaDetalleVentaLote.remove(encontrado);
            System.out.println("Se elimino el Detalle Venta Lote " + detVenLoteId);
        }else {
            System.out.println("No se pudo eliminar el detalle venta lote " + detVenLoteId);
        }
    }

    public void buscarDetalleVentaLote(int detVenLoteId){
        Optional<DetalleVentaLote> busqueda = listaDetalleVentaLote.stream()
                .filter(i -> i.getDetVenLoteId() == detVenLoteId)
                .findFirst();

        if (busqueda.isPresent()){
            System.out.println("Detalle de Venta de Lote encontrado: " +toString());
        }else {
            System.out.println("No se encontro coincidencias con: " + detVenLoteId);
        }
    }
}
