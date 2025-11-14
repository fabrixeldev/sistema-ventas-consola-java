package dao;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.Optional;


public class ClienteDao {
    private Cliente cliente;

    private ArrayList<Cliente> listaClientes = new ArrayList<>();

    public void agregarCliente(int cliId, String cliNombre, String cliApellido, String cliCI, int cliCelular, String cliDireccion, String cliCorreoElec){
        Cliente clienteNuevo = new Cliente(cliId, cliNombre, cliApellido, cliCI, cliCelular, cliDireccion, cliCorreoElec);
        listaClientes.add(clienteNuevo);
        System.out.println("Se registro el cliente: " + cliNombre + " " + cliApellido);
    }

    public void listarClientes (){
        if (!listaClientes.isEmpty()){
            listaClientes.stream()
                    .forEach(System.out::println);
        }else{
            System.out.println("No existen datos para mostrar");
        }

    }

    public void editarClientes(int cliId, String cliNombre, String cliApellido, String cliCI, int cliCelular, String cliDireccion, String cliCorreoElec){
        for (Cliente cliente : listaClientes){
            if (cliente.getCliId() == cliId){
                if (!cliNombre.equals("")){
                    cliente.setCliNombre(cliNombre);
                }
                if (!cliApellido.equals("")){
                    cliente.setCliApellido(cliApellido);
                }
                if (!cliCI.equals("")){
                    cliente.setCliCI(cliCI);
                }
                if (cliCelular == 0){
                    cliente.setCliCelular(cliCelular);
                }
                if (!cliDireccion.equals("")){
                    cliente.setCliDireccion(cliDireccion);
                }
                if (!cliCorreoElec.equals("")){
                    cliente.setCliCorreoElec(cliCorreoElec);
                }
            }
        }
    }

    public void eliminarClientes(int cliId){
       Cliente encontrado = null;
        for (Cliente c : listaClientes){
            if (c.getCliId() == cliId){
                encontrado = c;
                break;
            }
        }

        if (encontrado != null){
            listaClientes.remove(encontrado);
            System.out.println("Se elimino el cliente: " + encontrado.getCliId() + " " + encontrado.getCliNombre());
        }else {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public void buscarCliente(String cliNombre){
        Optional<Cliente> busqueda = listaClientes.stream()
                .filter(c -> c.getCliNombre().equals(cliNombre))
                .findFirst();

        busqueda.ifPresentOrElse(
                c -> System.out.println("Se encontro el cliente: " + cliNombre + " " + c.toString()),
                () -> System.out.println("No se encontraron coincidencias con: " + cliNombre)
        );
    }

    public Cliente obtenerClientePorId(int cliId){
        for (Cliente cli: listaClientes){
            if (cli.getCliId() == cliId){
                return cli;
            }
        }
        return null;
    }
}
