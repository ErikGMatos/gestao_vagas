package br.com.erikmatos.gestao_vagas.modules.candidate.reopository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erikmatos.gestao_vagas.modules.candidate.entity.ApplyJobEntity;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {

}
