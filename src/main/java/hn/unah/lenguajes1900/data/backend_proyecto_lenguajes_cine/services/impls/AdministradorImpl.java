package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.Validations.Validation;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.entities.Administrador;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.repositories.AdministradorRepository;
import hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine.services.AdministradorService;

@Service
public class AdministradorImpl implements AdministradorService{

    @Autowired
    private AdministradorRepository adminRepository;


    @Override
    public Administrador crearAdministrador(Administrador admin) {
        Validation validator = new Validation();

        if(admin.getNombreCompleto().trim().matches("[A-Za-záéíóúäëïöü]+\\\\s?)+") &&
        validator.validarTelefono(admin.getTelefono()) && validator.validarCorreo(admin.getCorreo())){
            return this.adminRepository.save(admin);
        }
        System.out.println(admin.getNombreCompleto().trim().matches("([A-Za-záéíóúäëïöü]+\\s?)+"));
        System.out.println(validator.validarTelefono(admin.getTelefono()));
        System.out.println(validator.validarCorreo(admin.getCorreo()));
        return null;
    }

    @Override
    public List<Administrador> obtenerAdministradores() {
         return (List<Administrador>)this.adminRepository.findAll();
    }

    @Override
    public Administrador obtenerAdministradorPorId(long codigoAdmin) {
        if(this.adminRepository.existsById(codigoAdmin)){
            return this.adminRepository.findById(codigoAdmin).get();
        }
        System.out.println("No existe ningún admin con este ID");
        return null;
    }

    @Override
    public Administrador obteneAdministradorPorCorreo(String correo, String contrasenia) {
        List<Administrador> Administradores = (List<Administrador>) this.adminRepository.findAll();

        for(Administrador Administrador : Administradores){

            if(Administrador.getCorreo().equals(correo)){
                if(Administrador.getContrasenia().equals(contrasenia));
                return Administrador;
            }
            System.out.println("La contraseña no es correcta.");
        }
        System.out.println("El correo o la contraseña son incorrectos.");
        return null;
    }

    @Override
    public Administrador editarAdmin(long codigoAdmin, Administrador adminEdit) {
       Administrador adminActualizar = this.adminRepository.findById(codigoAdmin).get();
       if (null != adminActualizar) {
        Validation validator = new Validation();
            if(adminEdit.getNombreCompleto().trim().matches("([A-Za-záéíóúäëïöü]+\\s?)+") && 
            validator.validarTelefono(adminEdit.getTelefono()) && validator.validarCorreo(adminEdit.getCorreo())){

                adminActualizar.setNombreCompleto(adminEdit.getNombreCompleto());
                adminActualizar.setFechaNacimiento(adminEdit.getFechaNacimiento());
                adminActualizar.setCorreo(adminEdit.getCorreo());
                adminActualizar.setContrasenia(adminEdit.getContrasenia());
                adminActualizar.setTelefono(adminEdit.getTelefono());

                this.adminRepository.save(adminActualizar);
            }
             return adminActualizar;
       }
        return null;
    }
    
}
