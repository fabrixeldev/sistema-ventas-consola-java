package dao;


import modelo.Categoria;
import modelo.Laboratorio;
import modelo.Presentacion;
import modelo.Producto;
import java.awt.image.BufferedImage;

import java.util.*;

public class ProductoDao {
    Producto producto;
    Categoria categoria;
    Laboratorio laboratorio;
    Presentacion presentacion;

    private ArrayList<Producto> listaProductos = new ArrayList<>();

    public void agregarProductos(int prodId, String prodCodigo, String prodNombre, String prodConcentracion, String prodAdicional, BufferedImage prodImagen, double prodPrecio, Categoria categoria, Presentacion presentacion, Laboratorio laboratorio){
        Producto nuevoProducto = new Producto(prodId, prodCodigo, prodNombre, prodConcentracion, prodAdicional, prodImagen, prodPrecio, categoria, presentacion, laboratorio);
        listaProductos.add(nuevoProducto);
        System.out.println("Se registro el producto " + nuevoProducto.getProdCodigo());
    }

    public void listarProductos(){
        if (!listaProductos.isEmpty()){
            listaProductos.stream()
                    .forEach(System.out::println);
        }else {
            System.out.println("No existen datos");
        }
    }

    public void editarProductos(int prodId, String prodCodigo, String prodNombre, String prodConcentracion, String prodAdicional, BufferedImage prodImagen, double prodPrecio, Categoria categoria, Presentacion presentacion, Laboratorio laboratorio){
        for (Producto prod : listaProductos){
            if (prod.getProdId() == prodId){
                prod.setProdId(prodId);
                if (!prodCodigo.isEmpty()){
                    prod.setProdCodigo(prodCodigo);
                }
                if ((!prodNombre.isEmpty())){
                    prod.setProdNombre(prodNombre);
                }
                if (!prodConcentracion.isEmpty()){
                    prod.setProdConcentracion(prodConcentracion);
                }
                if (!prodAdicional.isEmpty()){
                    prod.setProdAdicional(prodAdicional);
                }
                if (prodImagen != null){
                    prod.setProdImagen(prodImagen);
                }
                if (prodPrecio !=  0){
                    prod.setProdPrecio(prodPrecio);
                }
                if (categoria != null){
                    prod.setCategoria(categoria);
                }
                if (presentacion != null){
                    prod.setPresentacion(presentacion);
                }
                if (laboratorio != null){
                    prod.setLaboratorio(laboratorio);
                }
            }
        }

    }

    public void eliminarProductos(int prodId){
         //boolean eliminado = listaProductos.removeIf(p -> p.getProdId() == prodId);

         Producto encontrado = null;
         for (Producto p : listaProductos){
             if (p.getProdId() == prodId){
                 encontrado = p;
                 break;
             }
         }

         if (encontrado != null){
             listaProductos.remove(encontrado);
             System.out.println("Producto " + encontrado.getProdCodigo() + " eliminado");
         }else {
             System.out.println("No se encuentran coincidencias con " + prodId);
         }
    }


    public void buscarProducto(String prodNombre){
        Optional<Producto> busqueda = listaProductos.stream()
                .filter(p -> p.getProdNombre().equals(prodNombre))
                .findFirst();

        busqueda.ifPresentOrElse(
                p -> System.out.println("Producto encontrado : " + p.toString()),
                () -> System.out.println("Producto no encontrado")
        );
    }

    public double productoCaro(){

        Optional<Producto> prodCaro = listaProductos.stream()
                .max(Comparator.comparing(Producto::getProdPrecio));

        prodCaro.ifPresentOrElse(
                pc -> System.out.println("El producto mas caro es: " + pc.getProdNombre() + " - " + pc.getProdPrecio()),
                () -> System.out.println("No hay productos")
        );
        return prodCaro.map(Producto::getProdPrecio).orElse(0.0);

    }

    public Producto obtenerProductoPorId(int prodId){
        for (Producto prod: listaProductos){
            if (prod.getProdId() == prodId){
                return prod;
            }
        }
        return null;
    }
}
