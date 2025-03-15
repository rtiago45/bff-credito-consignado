package com.bffcredito.repository;

import com.bffcredito.model.Proposta;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PropostaRepository {

    private static final String PROPOSTA_KEY = "propostas";

    private final RedisTemplate<String, Object> redisTemplate;

    public PropostaRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void salvarProposta(Proposta proposta) {
        redisTemplate.opsForList().rightPush(PROPOSTA_KEY, proposta);
    }

    public List<Proposta> listarPropostas() {
        List<Object> objetos = redisTemplate.opsForList().range(PROPOSTA_KEY, 0, -1);
        return objetos.stream().map(obj -> (Proposta) obj).collect(Collectors.toList());
    }

    public Proposta obterProposta(Long id) {
        return listarPropostas().stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public void limparCache() {
        redisTemplate.delete(PROPOSTA_KEY);
    }
}
