package br.com.erikmatos.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.erikmatos.gestao_vagas.exceptions.UserFoundException;
import br.com.erikmatos.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.erikmatos.gestao_vagas.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });

        var passsword = passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(passsword);
        return this.candidateRepository.save(candidateEntity);
    }
}
