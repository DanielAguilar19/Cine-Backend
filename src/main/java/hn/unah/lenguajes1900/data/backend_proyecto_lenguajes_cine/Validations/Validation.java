package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.Validations;

import java.util.regex.Pattern;

public class Validation {
    
    public static final int N_ASIENTOS_FILA = 10;
    public static final int N_FILAS_SALA_VIP = 2;
	public static final int N_FILAS_SALA_NORMAL = 4;
    public static final String NOMBRE_CLIENTE_REGEX = "[A-Za-záéíóúäëïöü]+\\s?";
    public static final String TELEFONO_CLIENTE_REGEX = "(\\(?\\+504\\)?)? *[983]\\d{3}-?\\d{4}";
    public static final String CORREO_CLIENTE_REGEX = "[A-Za-z0-9._]+@[A-Za-z0-9]+\\.[A-Z|a-z]{2,}";

    public boolean validarNombre(String nombre){
        return Pattern.matches(NOMBRE_CLIENTE_REGEX, nombre);
    }

    public boolean validarTelefono(String telefono){
        return Pattern.matches(TELEFONO_CLIENTE_REGEX, telefono);
    }

    public boolean validarCorreo(String correo){
        return Pattern.matches(CORREO_CLIENTE_REGEX, correo);
    }
}
