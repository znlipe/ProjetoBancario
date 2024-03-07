package znlipe.com.github.ProjetoBancario.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreditCardNumber
  private String numero;

  //private BANDEIRA_CARTAO bandeira;
  private BigDecimal limite;
  private LocalDate validade;
  private Integer cvv;
  private BigDecimal debito;
  private Boolean credito;
  private Boolean compraOnline;

}
