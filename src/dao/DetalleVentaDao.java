package dao;

import modelo.DetalleVenta;
import modelo.Venta;

import java.util.ArrayList;
import java.util.Optional;

public class DetalleVentaDao {
    private Venta venta;

    ArrayList<DetalleVenta> listaDetalleVenta = new ArrayList<>();

    public void agregarDetalleVenta(int detVenId, double detVenPrecio, double detVenDescuento, Venta venta){
        DetalleVenta nuevoDetalleVenta = new DetalleVenta(detVenId, detVenPrecio, detVenDescuento, venta);
        listaDetalleVenta.add(nuevoDetalleVenta);
        System.out.println("Se registro el Detalle Venta: " + nuevoDetalleVenta.getDetVenId());
    }

    public void listarDetalleVenta(){
        if (listaDetalleVenta.size() != 0){
            System.out.println(listaDetalleVenta);
        }else{
            System.out.println("No existen datos para mostrar");
        }
    }

    public void editarDetalleVenta(int detVenId, double detVenPrecio, double detVenDescuento, Venta venta){
        for (DetalleVenta detalleVenta: listaDetalleVenta){
            if (detalleVenta.getDetVenId() == detVenId){
                if (detVenPrecio != 0){
                    detalleVenta.setDetVenPrecio(detVenPrecio);
                }
                if (detVenDescuento != 0){
                    detalleVenta.setDetVenDescuento(detVenDescuento);
                }
                if (venta != null){
                    detalleVenta.setVenta(venta);
                }
            }
        }
    }

    public void eliminarDetalleVenta(int detVenId){
        DetalleVenta encontrado = null;
        for (DetalleVenta dv : listaDetalleVenta){
            if (dv.getDetVenId() == detVenId){
                encontrado = dv;
            }
        }

        if (!encontrado.equals(null)){
            listaDetalleVenta.remove(encontrado);
            System.out.println("Se elimino: " + detVenId);
        }else {
            System.out.println("No se encontro el detalle venta " +detVenId);
        }
    }

    public void buscarDetalleVenta(int detVenId){
        Optional<DetalleVenta> busqueda = listaDetalleVenta.stream()
                .filter(s ->  s.getDetVenId() == detVenId)
                .findFirst();

        busqueda.ifPresentOrElse(
                s -> System.out.println("Detalle Venta encontrado" + toString()),
                () -> System.out.println("No se encontro el " + detVenId)
        );
    }

    public DetalleVenta obtenerDetalleVentaPorId(int detVenId){
        for (DetalleVenta detVen: listaDetalleVenta){
            if (detVen.getDetVenId() == detVenId){
                return detVen;
            }
        }
        return null;
    }
}
