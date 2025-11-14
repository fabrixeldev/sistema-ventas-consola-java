package dao;

import modelo.Categoria;

import java.util.ArrayList;
import java.util.Optional;

public class CategoriaDao {
    private ArrayList<Categoria> listaCategoria = new ArrayList<>();

    public void agregarCategoria(int cateId, String cateNombre, String cateDescripcion){
        Categoria categoriaNueva = new Categoria(cateId, cateNombre, cateDescripcion);
        listaCategoria.add(categoriaNueva);
        System.out.println("Se registro la categoria: " + categoriaNueva.getCateNombre());
    }

    public void listarCategoria(){
        if (listaCategoria.size() != 0){
            System.out.println(listaCategoria);
        }else{
            System.out.println("No existen datos para mostrar");
        }
    }

    public void editarCategoria(int cateId, String cateNombre, String cateDescripcion){
        for (Categoria categoria: listaCategoria){
            if (categoria.getCateId() == cateId){
                if (!cateNombre.equals("")){
                    categoria.setCateNombre(cateNombre);
                }
                if (!cateDescripcion.equals("")){
                    categoria.setCateDescripcion(cateDescripcion);
                }
            }
        }
    }

    public void eliminarCategoria(int cateId){
        Categoria encontrado = null;
        for (Categoria c:listaCategoria ){
            if (c.getCateId() == cateId){
                encontrado = c;
            }
        }

        if (encontrado != null){
            listaCategoria.remove(encontrado);
            System.out.println("Se elimino la categoria" + cateId);
        }else {
            System.out.println("No se pudo eliminar " + cateId);
        }
    }

    public void buscarCategoria(String cateNombre){
        Optional<Categoria> busqueda = listaCategoria.stream()
                .filter(s -> s.getCateNombre().equals(cateNombre))
                .findFirst();

        if (busqueda.isPresent()){
            System.out.println("Categoria encontrada: " + toString());
        }else {
            System.out.println("No se encontro coincidencias con: " + cateNombre);
        }
    }

    public Categoria obtenerCategoriaPorId(int cateId){
        for (Categoria cate: listaCategoria){
            if (cate.getCateId() == cateId){
                return cate;
            }
        }
        return null;
    }
}
