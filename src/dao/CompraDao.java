package dao;

import modelo.Compra;
import modelo.Proveedor;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class CompraDao {
    private Usuario usuario;
    private Proveedor proveedor;

    private ArrayList<Compra> listaCompra = new ArrayList<>();

    public void agregarCompra(int compraId, String compraCodigo, String compraNumComp, Date compraFecha, double compraTotal, boolean compraEstado, Usuario usuario, Proveedor proveedor){
        Compra compraNueva = new Compra(compraId, compraCodigo, compraNumComp, compraFecha, compraTotal, compraEstado, usuario, proveedor);
        listaCompra.add(compraNueva);
        System.out.println("Se registro la Compra: " + compraNueva.getCompraCodigo());
    }

    public void listarCompra (){
        if (listaCompra.size() != 0){
            System.out.println(listaCompra);
        }else{
            System.out.println("No existen registros para mostrar");
        }
    }

    public void editarCompra(int compraId, String compraCodigo, String compraNumComp, Date compraFecha, double compraTotal, boolean compraEstado, Usuario usuario, Proveedor proveedor){
        for (Compra compra: listaCompra){
            if (compra.getCompraId() == compraId){
                if (!compraCodigo.equals("")){
                    compra.setCompraCodigo(compraCodigo);
                }
                if (!compraNumComp.equals("")){
                    compra.setCompraNumComp(compraNumComp);
                }
                if (compraFecha != null){
                    compra.setCompraFecha(compraFecha);
                }
                if (compraTotal != 0){
                    compra.setCompraTotal(compraTotal);
                }
                if ((compraEstado != true) || (compraEstado != false)){
                    compra.setCompraEstado(compraEstado);
                }
                if (usuario != null){
                    compra.setUsuario(usuario);
                }
                if (proveedor != null){
                    compra.setProveedor(proveedor);
                }
            }
        }
    }

    public void eliminarCompra(int compraId){
        Compra encontrado = null;
        for (Compra comp: listaCompra){
            if (comp.getCompraId() == compraId){
                encontrado = comp;
            }
        }

        if (encontrado != null){
            listaCompra.remove(encontrado);
            System.out.println("Se elimino " + compraId);
        }else {
            System.out.println("No se pudo eliminar: " + compraId);
        }
    }

    public void buscarCompra(String compraNumComp){
        Optional<Compra> busqueda = listaCompra.stream()
                .filter(s -> s.getCompraNumComp().equals(compraNumComp))
                .findFirst();

        if (busqueda.isPresent()){
            System.out.println("Compra encontrada: " + toString());
        }else {
            System.out.println("No se encontro coincidencias con: " + compraNumComp);
        }
    }

    public Compra obtenerCompraPorId(int compraId){
        for (Compra compra: listaCompra){
            if (compra.getCompraId() == compraId){
                return compra;
            }
        }
        return null;
    }
}
