package dao;

import modelo.Cliente;
import modelo.Usuario;
import modelo.Venta;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class VentaDao {
    private Cliente cliente;
    private Usuario usuario;

    ArrayList<Venta> listaVentas = new ArrayList<>();

    public void agregarVenta(int ventId, String ventCadigo, String ventNumCompro, Date ventFecha, double ventTotal, boolean ventEstado, Usuario usuario, Cliente cliente){
        Venta ventaNueva = new Venta(ventId, ventCadigo, ventNumCompro, ventFecha, ventTotal, ventEstado, usuario, cliente);
        listaVentas.add(ventaNueva);
        System.out.println("Se registro la venta: " + ventaNueva.getVentCodigo());
    }

    public void listarVentas(){
        for (Venta venta: listaVentas){
            if (!listaVentas.isEmpty()){
                listaVentas.stream()
                        .forEach(System.out::println);
            }else{
                System.out.println("No hay datos para mostrar");
            }
        }
    }

    public void editarVenta(int ventId, String ventCadigo, String ventNumCompro, Date ventFecha, double ventTotal, boolean ventEstado, Usuario usuario, Cliente cliente){
        for (Venta venta : listaVentas){
            if (venta.getVentId() == ventId){
                if (!ventCadigo.equals("")){
                    venta.setVentCodigo(ventCadigo);
                }
                if (!ventNumCompro.equals("")){
                    venta.setVentNumCompro(ventNumCompro);
                }
                if (!ventFecha.equals("")){
                    venta.setVentFecha(ventFecha);
                }
                if (ventTotal == 0){
                    venta.setVentTotal(ventTotal);
                }
                if ((ventEstado != true) || (ventEstado != false)){
                    venta.setVentEstado(ventEstado);
                }
                if (cliente != null){
                    venta.setCliente(cliente);
                }
                if (usuario != null){
                    venta.setUsuario(usuario);
                }
            }
        }
    }

    public void eliminarVenta(int ventId){
        Venta encontrado = null;
        for (Venta v : listaVentas){
            if (v.getVentId() == ventId){
                encontrado = v;
                break;
            }
        }

        if (encontrado != null){
            listaVentas.remove(encontrado);
            System.out.println("Se elimino la venta: " + ventId);
        }else {
            System.out.println("No hay coincidencias con: " + ventId);
        }
    }

    public void buscarVenta(String ventCodigo){
        Optional<Venta> busqueda = listaVentas.stream()
                .filter(v -> v.getVentCodigo().equals(ventCodigo))
                .findFirst();

        busqueda.ifPresentOrElse(
                v -> System.out.println("Se encontro la venta: " + v.toString()),
                () -> System.out.println("No se encontro coincidencias con: " + ventCodigo)
        );
    }

    public Venta obtenerVentaPorId(int ventId){
        for (Venta venta: listaVentas){
            if (venta.getVentId() == ventId){
                return venta;
            }
        }
        return null;
    }
}
