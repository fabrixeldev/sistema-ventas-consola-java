package dao;

import modelo.Bitacora;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class BitacoraDao {
    private Usuario usuario;

    private ArrayList<Bitacora> listaBitacora = new ArrayList<>();

    public void agregarBitacora(int bitaId, String bitaCod, Date bitaFecha, Date bitaHoraInicio, Date bitaHoraFin, String bitaTipoUsu, Date bitaAño, Usuario usuario){
        Bitacora bitacoraNueva = new Bitacora(bitaId, bitaCod, bitaFecha, bitaHoraInicio, bitaHoraFin, bitaTipoUsu, bitaAño, usuario);
        listaBitacora.add(bitacoraNueva);
        System.out.println("Se registro la bitacora: " + bitacoraNueva.getBitaCod());
    }

    public void listarBitacora (){
        if (listaBitacora.size() != 0){
            System.out.println(listaBitacora);
        }else{
            System.out.println("No existen datos para mostrar");
        }
    }

    public void editarBitacora(int bitaId, String bitaCod, Date bitaFecha, Date bitaHoraInicio, Date bitaHoraFin, String bitaTipoUsu, Date bitaAño, Usuario usuario){
        for (Bitacora bitacora: listaBitacora){
            if (bitacora.getBitaId() == bitaId){
                if (!bitaCod.equals("")){
                    bitacora.setBitaCod(bitaCod);
                }
                if (bitaFecha != null){
                    bitacora.setBitaFecha(bitaFecha);
                }
                if (bitaHoraInicio != null){
                    bitacora.setBitaHoraInicio(bitaHoraInicio);
                }
                if (bitaHoraFin != null){
                    bitacora.setBitaHoraFin(bitaHoraFin);
                }
                if (!bitaTipoUsu.equals("")){
                    bitacora.setBitaTipoUsu(bitaTipoUsu);
                }
                if (usuario != null){
                    bitacora.setUsuario(usuario);
                }
            }
        }
    }

    public void eliminarBitacora (int bitaId){
        Bitacora encontrado = null;
        for (Bitacora b : listaBitacora){
            if (b.getBitaId() == bitaId){
                encontrado = b;
            }
        }

        if (encontrado != null){
            listaBitacora.remove(encontrado);
            System.out.println("Se elimino " + encontrado.getBitaCod());
        }
    }

    public void buscarBitacora(int bitaId){
        Optional<Bitacora> busqueda = listaBitacora.stream()
                .filter(s -> s.getBitaId() == bitaId)
                .findFirst();

        if (busqueda.isPresent()){
            System.out.println("Bitacora encontrada: " + toString());
        }else {
            System.out.println("No es encontro la bitacora: " + bitaId);
        }
    }
}
