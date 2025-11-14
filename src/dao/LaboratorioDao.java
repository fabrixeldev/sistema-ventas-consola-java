package dao;

import modelo.Laboratorio;

import java.util.ArrayList;
import java.util.Optional;

public class LaboratorioDao {
    private ArrayList<Laboratorio> listaLaboratorio = new ArrayList<>();

    public void agregarLaboratorio(int labId, String labNombre, String labDescripcion){
        Laboratorio laboratorioNuevo= new Laboratorio(labId, labNombre, labDescripcion);
        listaLaboratorio.add(laboratorioNuevo);
        System.out.println("Se registro el laboratorio: " + laboratorioNuevo.getLabNombre());
    }

    public void listarLaboratorio(){
        if (listaLaboratorio.size() != 0 ){
            System.out.println(listaLaboratorio);
        }else{
            System.out.println("No existen datos para mostrar");
        }
    }

    public void editarLaboratorio(int labId, String labNombre, String labDescripcion){
        for (Laboratorio laboratorio: listaLaboratorio){
            if (laboratorio.getLabId() == labId){
                if (!labNombre.equals("")){
                    laboratorio.setLabNombre(labNombre);
                }
                if (!labDescripcion.equals("")){
                    laboratorio.setLabDescripcion(labDescripcion);
                }
            }
        }
    }

    public void eliminarLaboratorio(int labId){
        Laboratorio encontrado = null;
        for (Laboratorio lab : listaLaboratorio){
            if (lab.getLabId() == labId){
                encontrado = lab;
            }
        }

        if (encontrado != null){
            listaLaboratorio.remove(encontrado);
            System.out.println("Se elimino el laboratorio: " + labId);
        }else {
            System.out.println("No se pudo eliminar el laboratorio " + labId);
        }
    }

    public void buscarLaboratorio(String labNombre){
        Optional<Laboratorio> busqueda = listaLaboratorio.stream()
                .filter(s -> s.getLabNombre().equals(labNombre))
                .findFirst();

        if (busqueda.isPresent()){
            System.out.println("Laboratorio encontrado: " +toString());
        }else {
            System.out.println("No se encontro coincidencias con " + labNombre);
        }
    }

    public Laboratorio obtenerLaboratorioPorId(int labId){
        for (Laboratorio lab: listaLaboratorio){
            if (lab.getLabId() == labId){
                return lab;
            }
        }
        return null;
    }
}
