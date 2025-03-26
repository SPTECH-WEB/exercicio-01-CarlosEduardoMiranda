package com.boleto.apifatura.service;

import com.boleto.apifatura.model.Fatura;
import com.boleto.apifatura.repository.FaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaturaService {

    private final FaturaRepository faturaRepository;

    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public List<Fatura> listarFaturas() {
        return faturaRepository.findAll();
    }

    public Optional<Fatura> buscarFaturaPorId(Long id) {
        return faturaRepository.findById(id);
    }

    public Fatura cadastrarFatura(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    public Fatura atualizarFatura(Long id, Fatura faturaAtualizada) {
        Optional<Fatura> faturaExistente = faturaRepository.findById(id);
        if (faturaExistente.isPresent()) {
            faturaAtualizada.setId(id);
            return faturaRepository.save(faturaAtualizada);
        }
        return null;
    }

    public void deletarFatura(Long id) {
        faturaRepository.deleteById(id);
    }
}