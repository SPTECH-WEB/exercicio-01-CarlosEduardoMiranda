package com.boleto.apifatura.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Fatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O número do cartão é obrigatório")
    @Pattern(regexp = "\\d{16}", message = "O número do cartão deve conter exatamente 16 dígitos numéricos.")
    private String numeroCartao;

    @NotBlank(message = "O nome do titular é obrigatório")
    @Size(min = 3, max = 100, message = "O nome do titular deve ter entre 3 e 100 caracteres.")
    private String nomeTitular;

    @NotNull(message = "O valor é obrigatório.")
    @DecimalMin(value = "10.00", message = "O valor mínimo é 10.00.")
    @DecimalMax(value = "5000.00", message = "O valor máximo é 5000.00.")
    private Double valor;

    @NotNull(message = "A data de pagamento é obrigatória.")
    @FutureOrPresent(message = "A data de pagamento deve ser presente ou futura.")
    private LocalDate dataPagamento;

    @NotBlank(message = "O e-mail de contato é obrigatório.")
    @Email(message = "O e-mail deve ser válido.")
    private String emailContato;


}
