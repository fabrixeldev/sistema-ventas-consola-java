package dao;

import modelo.DetalleCompra;
import modelo.Lote;
import modelo.Producto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class LoteDao {
    private Producto producto;

    private ArrayList<Lote> listaLote = new ArrayList<>();

    public void agregarLote(int loteId, String loteCodigo, int loteCantidad, Date loteFechaCreacion, Date loteFechaVenc, Producto producto){
        Lote nuevoLote = new Lote(loteId, loteCodigo, loteCantidad, loteFechaCreacion, loteFechaVenc, producto);
        listaLote.add(nuevoLote);
        System.out.println("Se registro el Lote: " + nuevoLote.getLoteCodigo());
    }

    public void listarLote(){
        if (listaLote.size() != 0){
            System.out.println(listaLote);
        }else{
            System.out.println("No existen datos para mostrar");
        }
    }

    public void editarLote(int loteId, String loteCodigo, int loteCantidad, Date loteFechaCreacion, Date loteFechaVenc, Producto producto){
        for (Lote lote: listaLote){
            if (lote.getLoteId() == loteId){
                if (!loteCodigo.equals("")){
                    lote.setLoteCodigo(loteCodigo);
                }
                if (loteCantidad != 0){
                    lote.setLoteCantidad(loteCantidad);
                }
                if (loteFechaCreacion != null){
                    lote.setLoteFechaCreacion(loteFechaCreacion);
                }
                if (loteFechaVenc != null){
                    lote.setLoteFechaVenc(loteFechaVenc);
                }
                if (producto != null){
                    lote.setProducto(producto);
                }
            }
        }
    }

    public void eliminarLote(int loteId){
        Lote encontrado = null;
        for (Lote lote : listaLote){
            if (lote.getLoteId() == loteId){
                encontrado = lote;
            }
        }

        if (encontrado != null){
            listaLote.remove(encontrado);
            System.out.println("Se elimino el Lote: " + loteId);
        }else {
            System.out.println("No se pudo eliminar el lote " + loteId);
        }
    }

    public void buscarLote(int loteId){
        Optional<Lote> busqueda = listaLote.stream()
                .filter(i -> i.getLoteId() == loteId)
                .findFirst();

        if (busqueda.isPresent()){
            System.out.println("Lote encontrado: " + toString());
        }else {
            System.out.println("No se encontro coincidencias con " + loteId);
        }
    }

    public Lote obtenerLotePorId(int loteId){
        for (Lote lote: listaLote){
            if (lote.getLoteId() == loteId){
                return lote;
            }
        }
        return null;
    }
}
