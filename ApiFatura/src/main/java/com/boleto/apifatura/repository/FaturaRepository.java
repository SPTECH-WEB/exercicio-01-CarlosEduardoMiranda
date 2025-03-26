package com.boleto.apifatura.repository;
import com.boleto.apifatura.model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {
}
