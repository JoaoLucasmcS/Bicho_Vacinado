package com.BichoVacinado.BichoVacinado.service;

import com.BichoVacinado.BichoVacinado.dto.request.UsuarioRequest;
import com.BichoVacinado.BichoVacinado.dto.request.VacinaRequest;
import com.BichoVacinado.BichoVacinado.dto.response.UsuarioResponse;
import com.BichoVacinado.BichoVacinado.dto.response.VacinaResponse;
import com.BichoVacinado.BichoVacinado.model.Usuario;
import com.BichoVacinado.BichoVacinado.model.Vacina;
import com.BichoVacinado.BichoVacinado.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResponse cadastrar(UsuarioRequest request) {
        Usuario usuario = toEntity(request);
        return toResponse(usuarioRepository.save(usuario));
    }

    public UsuarioResponse buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return toResponse(usuario);
    }

    public UsuarioResponse atualizar(Long id, UsuarioRequest request) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(request.getNome());

        return toResponse(usuarioRepository.save(usuario));
    }

    public void deletar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuarioRepository.delete(usuario);
    }

    public List<UsuarioResponse> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private Usuario toEntity(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        return usuario;
    }

    private UsuarioResponse toResponse(Usuario usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .build();
    }
}