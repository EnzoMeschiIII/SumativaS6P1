package Formativa2Semana6package.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Formativa2Semana6package.model.Usuario;
import Formativa2Semana6package.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }
    
    @Override
    public Usuario createUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario usuario){
        if(usuarioRepository.existsById(id)){
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        else{
            return null;
        }

    }

    @Override
    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
