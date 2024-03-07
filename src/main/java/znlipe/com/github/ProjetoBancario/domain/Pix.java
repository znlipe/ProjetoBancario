package znlipe.com.github.ProjetoBancario.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pix {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BigDecimal valor;
  private LocalDate whenCreated;

  @ManyToOne //é vários pix pra uma conta, não tem como fazer um pix pra várias contas
  private Conta contaOrigem;

  //isso aqui é trabalho do bacen apontar pra uma conta?
  private String chaveDestino;

}
