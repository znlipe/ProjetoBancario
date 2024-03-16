package znlipe.com.github.ProjetoBancario.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import znlipe.com.github.ProjetoBancario.domain.enums.CardIdentification;

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
  private String number;

  @ManyToOne
  @JoinColumn(name = "currentAccount_id")
  private CurrentAccount account;

  @Length(max = 3, min = 3)
  private Integer cvv;

  private Boolean credit;
  private Boolean blocked;
  private Boolean onlineShopping;

  private BigDecimal limit = new BigDecimal(0);

  @JsonFormat(pattern = "dd/MM/yyyy HH:min")
  private LocalDateTime validity;

  private Integer identification;

  public CardIdentification getIdentification() {
    return CardIdentification.toEnum(this.identification);
  }

  public void setIdentification(CardIdentification cardIdentification) {
    this.identification = cardIdentification.getCod();
  }

}
