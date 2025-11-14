package dao;

import modelo.Compra;
import modelo.DetalleCompra;
import modelo.Lote;
import modelo.Producto;

import java.util.ArrayList;
import java.util.Optional;

public class DetalleCompraDao {
    private Compra compra;
    private Producto producto;

    private ArrayList<DetalleCompra> listaDetalleCompra = new ArrayList<>();

    public void agregarDetalleCompra(int detCompId, int detCompCantidad, double detCompPrecio, Producto producto, Compra compra){
        DetalleCompra detalleCompraNuevo = new DetalleCompra(detCompId, detCompCantidad, detCompPrecio, producto, compra);
        listaDetalleCompra.add(detalleCompraNuevo);
        System.out.println("Se registro el Detalle de Compra: " + detalleCompraNuevo.getDetCompId());
    }

    public void listarDetalleCompra(){
        if (listaDetalleCompra.size() != 0){
            System.out.println(listaDetalleCompra);
        }else{
            System.out.println("No existen datos para mostrar");
        }
    }

    public void editarDetalleCompra(int detCompId, int detCompCantidad, double detCompPrecio, Producto producto, Compra compra){
        for (DetalleCompra detalleCompra: listaDetalleCompra){
            if (detalleCompra.getDetCompId() == detCompId){
                if (detCompCantidad != 0){
                    detalleCompra.setDetCompCantidad(detCompCantidad);
                }
                if (detCompPrecio != 0){
                    detalleCompra.setDetCompPrecio(detCompPrecio);
                }
                if (producto != null){
                    detalleCompra.setProducto(producto);
                }
                if (compra != null){
                    detalleCompra.setCompra(compra);
                }
            }
        }
    }

    public void eliminarDetalleCompra(int detCompId){
        DetalleCompra encontrado = null;
        for (DetalleCompra dc: listaDetalleCompra){
            if (dc.getDetCompId() == detCompId){
                encontrado = dc;
            }
        }

        if (encontrado != null){
            listaDetalleCompra.remove(encontrado);
            System.out.println("Se elimino " + detCompId);
        }else {
            System.out.println("No se pudo eliminar " + detCompId);
        }
    }

    public void buscarDetalleCompra(int detCompId){
        Optional<DetalleCompra> busqueda = listaDetalleCompra.stream()
                .filter(s -> s.getDetCompId() == detCompId)
                .findFirst();

        if (busqueda.isPresent()){
            System.out.println("Detalle Compra encontrado: " + toString());
        }else {
            System.out.println("No se encontro coincidencias con: " + detCompId);
        }
    }
}
