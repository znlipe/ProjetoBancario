package znlipe.com.github.ProjetoBancario.domain;

import jakarta.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ContaCorrente extends Conta{

  private List<Emprestimo> emprestimos = new ArrayList<>();
  private List<Card> cards = new ArrayList<>();
  private List<Checkbook> checkbook = new ArrayList<>();

}
