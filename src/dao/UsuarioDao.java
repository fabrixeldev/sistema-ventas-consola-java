package dao;

import modelo.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;


public class UsuarioDao {
    private Usuario usuario;

    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public void agregarUsuario (int usuId, String usuCodigo, String usuNombre, String usuApellido, Date usuFechaNac, String usuProfesion, String usuCI, int usuCelular, String usuGenero, String usuCargo, String usuLogin , String usuContrasena, boolean usuEstado){
        Usuario nuevoUsuario = new Usuario(usuId, usuCodigo, usuNombre, usuApellido, usuFechaNac, usuProfesion, usuCI, usuCelular, usuGenero, usuCargo, usuLogin, usuContrasena, usuEstado);
        listaUsuarios.add(nuevoUsuario);
        System.out.println("Se registro al usuario: " + nuevoUsuario.getUsuCodigo());
    }

    public void listarUsuarios(){
        if (!listaUsuarios.isEmpty()){
            listaUsuarios.stream()
                    .forEach(System.out::println);
        }else {
            System.out.println("No existen usuarios registrados");
        }
    }

    public void editarUsuarios(int usuId, String usuCodigo, String usuNombre, String usuApellido, Date usuFechaNac, String usuProfesion, String usuCI, int usuCelular, String usuGenero, String usuCargo, String usuLogin , String usuContrasena, boolean usuEstado){
        for (Usuario usuario : listaUsuarios){
            if (usuario.getUsuId() == usuId){
                if (!usuCodigo.equals("")){
                    usuario.setUsuCodigo(usuCodigo);
                }
                if (!usuNombre.equals("")){
                    usuario.setUsuNombre(usuNombre);
                }
                if (!usuApellido.equals("")){
                    usuario.setUsuApellido(usuApellido);
                }
                if (!usuFechaNac.equals("")){
                    usuario.setUsuFechaNac(usuFechaNac);
                }
                if (!usuProfesion.equals("")){
                    usuario.setUsuProfesion(usuProfesion);
                }
                if (!usuCI.equals("")){
                    usuario.setUsuCI(usuCI);
                }
                if (usuCelular != 0){
                    usuario.setUsuCI(usuCI);
                }
                if (!usuGenero.equals("")){
                    usuario.setUsuGenero(usuGenero);
                }
                if (!usuCargo.equals("")){
                    usuario.setUsuCargo(usuCargo);
                }
                if (!usuLogin.equals("")){
                    usuario.setUsuLogin(usuLogin);
                }
                if (!usuContrasena.equals("")){
                    usuario.setUsuContrasena(usuContrasena);
                }
                if ((usuEstado != true) || (usuEstado =! false)){
                    usuario.setUsuEstado(usuEstado);
                }
            }
        }
    }

    public void eliminarUsuario (int usuId){
        Usuario encontrado = null;
        for (Usuario usu : listaUsuarios){
            if (usu.getUsuId() == usuId){
                encontrado = usu;
            }
        }

        if (encontrado != null){
            listaUsuarios.remove(usuId);
            System.out.println("Se elimino el usuario: " + encontrado.getUsuCodigo());
        }else {
            System.out.println("No se encontro coincidencias");
        }
    }


    public void buscarUsuario (String usuNombre){
         Optional<Usuario> busqueda = listaUsuarios.stream()
                .filter(s -> s.getUsuNombre().equals(usuNombre))
                .findFirst();

         if (busqueda.isPresent()){
             System.out.println("Usuario encontrado: " + busqueda.stream().toList());
         }else {
             System.out.println("No hay coincidencias");
         }
    }


    public Usuario obtenerUsuarioPorId(int usuId){
        for (Usuario usu: listaUsuarios){
            if (usu.getUsuId() == usuId){
                return usu;
            }
        }
        return null;
    }
}


