package znlipe.com.github.ProjetoBancario.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public abstract class Account {

  @ManyToOne
  @JoinColumn(name = "agency_id")
  private Agency agency;

  @ManyToOne
  @JoinColumn(name = "persona_id")
  private Persona customer;

  @NotNull
  private String number;

  private BigDecimal balance = new BigDecimal(BigInteger.ZERO);

  @OneToMany
  private List<Extract> extractList = new ArrayList<>();
}
