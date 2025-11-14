import dao.*;
import modelo.*;

import java.sql.Connection;
import java.util.*;


public class Main {
    public static void main(String args[]) throws ClassNotFoundException {

        /*
        PRUEBAS DE LOS MODELOS y DAOs
         */
        Date fechaActual = new Date();
        
        UsuarioDao usuDao = new UsuarioDao();
        usuDao.agregarUsuario(1, "USER-1", "RODRIGO", "QUIZMAL", fechaActual, "ADMINISTRADOR DE EMPRESAS", "4856254", 74855624, "M", "CAJERO", "USESR01", "contrasena", true);
        usuDao.agregarUsuario(2, "USER-2","NATAEL", "LOPES", fechaActual, "CARTERO", "9145751", 72544862, "M", "CAJERO","USESR02", "contrasena", false);
        usuDao.listarUsuarios();
        usuDao.editarUsuarios(2, "","SEGAL", "LORENO", fechaActual, "CARTERO", "9145751", 72544862, "M", "","", "contrasena", true);
        usuDao.listarUsuarios();
        usuDao.buscarUsuario("RODRIGO");
        usuDao.listarUsuarios();


        BitacoraDao bitaDao = new BitacoraDao();
        bitaDao.agregarBitacora(1, "BITA-001", fechaActual, fechaActual, fechaActual, "Admin", fechaActual, usuDao.obtenerUsuarioPorId(1));


        CategoriaDao cateDao = new CategoriaDao();
        cateDao.agregarCategoria(1, "BENZODIACEPINAS", "SIN DESCRIPCION");
        cateDao.agregarCategoria(2, "ANTIHISTAMINICOS", "SIN DESCRIPCION");


        PresentacionDao presDao = new PresentacionDao();
        presDao.agregarPresentacion(1, "TABLETAS", "SIN DESCRIPCION");
        presDao.agregarPresentacion(2, "INYECTABLES", "SIN DESCRIPCION");


        LaboratorioDao labDao = new LaboratorioDao();
        labDao.agregarLaboratorio(1, "BAGO", "SIN DESCRIPCION");
        labDao.agregarLaboratorio(2, "LAFAR", "SIN DESCRIPCION");


        ProductoDao prodDao = new ProductoDao();
        prodDao.agregarProductos(1,"PROD-1", "CARBAMAZEPINA","5ML", "vacio", null, 15.6, cateDao.obtenerCategoriaPorId(1) , presDao.obtenerPresentacionPorId(1), labDao.obtenerLaboratorioPorId(1));
        prodDao.agregarProductos(2,"PROD-2", "FENTERMINA","10MG", "vacio", null, 15.6, cateDao.obtenerCategoriaPorId(1) , presDao.obtenerPresentacionPorId(1), labDao.obtenerLaboratorioPorId(1));
        prodDao.agregarProductos(3, "PROD-3", "CLONAZEPAM","5ML", "vacio", null, 15.6, cateDao.obtenerCategoriaPorId(1) , presDao.obtenerPresentacionPorId(1), labDao.obtenerLaboratorioPorId(1));
        prodDao.listarProductos();


        ProveedorDao provDao = new ProveedorDao();
        provDao.agregarProveedor(1, "PROV-001", "LAFAR", "NIT", "123456", 725664852, "AV. COSTALITOS", "lafar@mail.com");
        provDao.agregarProveedor(2, "PROV-002", "BAGO", "CI", "784512", 71234569, "CALLE CORRALITO", "bagodebagos@mail.com");


        CompraDao compDao = new CompraDao();
        compDao.agregarCompra(1, "CC-001", "CCPV123", fechaActual, 450.00, true, usuDao.obtenerUsuarioPorId(1), provDao.obtenerProveedorPorId(2));


        DetalleCompraDao detCompDao = new DetalleCompraDao();
        detCompDao.agregarDetalleCompra(1, 30, 15.00, prodDao.obtenerProductoPorId(1), compDao.obtenerCompraPorId(1) );


        LoteDao loteDao = new LoteDao();
        loteDao.agregarLote(1, "LOT-001", 1, fechaActual, fechaActual, prodDao.obtenerProductoPorId(1));


        ClienteDao cliDao = new ClienteDao();
        cliDao.agregarCliente(1, "GONZALO", "QUIROGA", "78451236", 74586215, "AVENIDA BRASIL", "usuario1@mail.com");
        cliDao.agregarCliente(2, "ROSALIA", "NERUVIA", "78451236", 74586215, "CALLE COLORADA", "usuario2@mail.com");
        cliDao.editarClientes(2, "", "COSTALES", "78451236", 74586215, "CALLE DE LAS NIEVES", "usuariomil@mail.com");
        cliDao.listarClientes();


        VentaDao ventaDao = new VentaDao();
        ventaDao.agregarVenta(1, "VENT-1", "VV568", fechaActual, 0.00, false, usuDao.obtenerUsuarioPorId(2), cliDao.obtenerClientePorId(2));
        ventaDao.listarVentas();


        DetalleVentaDao detVenDao = new DetalleVentaDao();
        detVenDao.agregarDetalleVenta(1, 1.80, 0.00, ventaDao.obtenerVentaPorId(1) );

        DetalleVentaLoteDao detVenLote = new DetalleVentaLoteDao();
        detVenLote.agregarDetalleVentaLote(1, 3, loteDao.obtenerLotePorId(1), detVenDao.obtenerDetalleVentaPorId(1));

    }
}