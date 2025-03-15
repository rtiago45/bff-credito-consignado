package com.bffcredito.repository;

import com.bffcredito.model.Simulacao;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SimulacaoRepository {

    private static final String SIMULACAO_KEY = "simulacoes";

    private final RedisTemplate<String, Object> redisTemplate;

    public SimulacaoRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void salvarSimulacao(Simulacao simulacao) {
        redisTemplate.opsForList().rightPush(SIMULACAO_KEY, simulacao);
    }

    public List<Simulacao> listarSimulacoes() {
        List<Object> objetos = redisTemplate.opsForList().range(SIMULACAO_KEY, 0, -1);
        return objetos.stream().map(obj -> (Simulacao) obj).collect(Collectors.toList());
    }

    public void limparCache() {
        redisTemplate.delete(SIMULACAO_KEY);
    }
}
