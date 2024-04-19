package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.Validations;

public class Validation {
    
    public static final int N_ASIENTOS_FILA = 10;
    public static final int N_FILAS_SALA_VIP = 2;
	public static final int N_FILAS_SALA_NORMAL = 4;
    public static final String NOMBRE_CLIENTE_REGEX = "[A-Za-záéíóúäëïöü]+\\s?";
    public static final String TELEFONO_CLIENTE_REGEX = "(\\(?\\+504\\)?)? *[983]\\d{3}-?\\d{4}";
    public static final String CORREO_CLIENTE_REGEX = "[A-Za-z0-9._]+@[A-Za-z0-9]+\\.[A-Z|a-z]{2,}";

    public boolean validarNombre(String nombre){
        if(nombre.trim().matches("[A-Za-záéíóúäëïöü]+\\s?")){
            return true;
        }
        return false;
    }

    public boolean validarTelefono(String telefono){
        if(telefono.trim().matches(TELEFONO_CLIENTE_REGEX)){
            return true;
        }
        return false;
    }

    public boolean validarCorreo(String correo){
        if(correo.trim().matches(CORREO_CLIENTE_REGEX)){
            return true;
        }
        return false;
    }
}
