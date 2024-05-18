package com.finance_dock.finance_dock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finance_dock.finance_dock.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Usuario findByFirebaseId(String firebaseId);
}
