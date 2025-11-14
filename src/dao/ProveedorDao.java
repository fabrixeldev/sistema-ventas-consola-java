package dao;

import modelo.Proveedor;

import java.util.ArrayList;
import java.util.Optional;

public class ProveedorDao {
    private ArrayList<Proveedor> listaProveedor = new ArrayList<>();

    public void agregarProveedor (int provId, String provCodigo, String provNombre, String provTipoDoc, String provNumDoc, int provCelular, String provDireccion, String provCorrElectr){
        Proveedor proveedorNuevo = new Proveedor(provId, provCodigo, provNombre, provTipoDoc, provNumDoc, provCelular, provDireccion, provCorrElectr);
        listaProveedor.add(proveedorNuevo);
        System.out.println("Se registro el Proveedor; " + proveedorNuevo.getProvCodigo());
    }

    public void listarProveedor (){
        if (listaProveedor.size() != 0){
            System.out.println(listaProveedor);
        }else{
            System.out.println("No existen datos para mostrar");
        }
    }

    public void editarProveedor(int provId, String provCodigo, String provNombre, String provTipoDoc, String provNumDoc, int provCelular, String provDireccion, String provCorrElectr){
        for (Proveedor proveedor : listaProveedor){
            if (proveedor.getProvId() == provId){
                if (!provCodigo.equals("")){
                    proveedor.setProvCodigo(provCodigo);
                }
                if (!provNombre.equals("")){
                    proveedor.setProvNombre(provNombre);
                }
                if (!provTipoDoc.equals("")){
                    proveedor.setProvTipDoc(provTipoDoc);
                }
                if (!provNumDoc.equals("")){
                    proveedor.setProvNumDoc(provNumDoc);
                }
                if (provCelular != 0){
                    proveedor.setProvCelular(provCelular);
                }
                if (!provDireccion.equals("")){
                    proveedor.setProvDireccion(provDireccion);
                }
                if (!provCorrElectr.equals("")){
                    proveedor.setProvCorrElectr(provCorrElectr);
                }
            }
        }
    }

    public void eliminarProveedor(int provId){
        Proveedor encontrado = null;
        for (Proveedor prov : listaProveedor){
            if (prov.getProvId() == provId){
                encontrado = prov;
            }
        }

        if (encontrado != null){
            listaProveedor.remove(encontrado);
            System.out.println("Se elimino " + provId);
        }else {
            System.out.println("No se pudo eliminar: " + provId);
        }
    }

    public void buscarProveedor(String provNombre){
        Optional<Proveedor> busqueda = listaProveedor.stream()
                .filter(s -> s.getProvNombre().equals(provNombre))
                .findFirst();

        if (busqueda.isPresent()){
            System.out.println("Proveedor encontrado: " +toString());
        }else{
            System.out.println("No se encuentra coincidencias con: " + provNombre);
        }
    }

    public Proveedor obtenerProveedorPorId(int provId){
        for (Proveedor prov: listaProveedor){
            if (prov.getProvId() == provId){
                return prov;
            }
        }
        return null;
    }
}
