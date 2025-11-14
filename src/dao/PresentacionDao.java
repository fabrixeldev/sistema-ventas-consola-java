package dao;

import modelo.Presentacion;

import java.util.ArrayList;
import java.util.Optional;

public class PresentacionDao {
    private ArrayList<Presentacion> listaPresentacion = new ArrayList<>();

    public void agregarPresentacion(int presId, String presNombre, String presDescripcion) {
        Presentacion presentacionNueva = new Presentacion(presId, presNombre, presDescripcion);
        listaPresentacion.add(presentacionNueva);
        System.out.println("Se registro la presentacion: " + presentacionNueva.getPresNombre());
    }

    public void listarPresentacion() {
        if (listaPresentacion.size() != 0) {
            System.out.println(listaPresentacion);
        } else {
            System.out.println("No existen datos para mostrar");
        }
    }

    public void editarPresentacion(int presId, String presNombre, String presDescripcion) {
        for (Presentacion presentacion : listaPresentacion){
            if (presentacion.getPresId() == presId){
                if (!presNombre.equals("")){
                    presentacion.setPresNombre(presNombre);
                }
                if (!presDescripcion.equals("")){
                    presentacion.setPresDescripcion(presDescripcion);
                }
            }
        }
    }

    public void eliminarPresentacion(int presId){
        Presentacion encontrado = null;
        for (Presentacion p: listaPresentacion){
            if (p.getPresId() == presId){
                encontrado = p;
            }
        }

        if (encontrado != null){
            listaPresentacion.remove(encontrado);
            System.out.println("Se elimino la presentacion: " + presId);
        }else {
            System.out.println("No se pudo eliminar la presentacion " + presId);
        }
    }

    public void buscarPresentacion(String presNombre){
        Optional<Presentacion> busqueda = listaPresentacion.stream()
                .filter(s -> s.getPresNombre().equals(presNombre))
                .findFirst();

        if (busqueda.isPresent()){
            System.out.println("Presentacion encontrada: " + toString());
        }else {
            System.out.println("No se encontro coincidencias con " + presNombre);
        }
    }

    public Presentacion obtenerPresentacionPorId(int presId){
        for (Presentacion pres: listaPresentacion){
            if (pres.getPresId() == presId){
                return pres;
            }
        }
        return null;
    }
}
