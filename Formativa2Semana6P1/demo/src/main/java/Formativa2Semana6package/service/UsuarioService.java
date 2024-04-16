package Formativa2Semana6package.service;

import java.util.List;
import java.util.Optional;

import Formativa2Semana6package.model.Usuario;

public interface UsuarioService {
    List<Usuario> getAllUsuarios();
    Optional<Usuario> getUsuarioById(Long id);
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(Long id, Usuario usuario);
    void deleteUsuario(Long id);
    
}
