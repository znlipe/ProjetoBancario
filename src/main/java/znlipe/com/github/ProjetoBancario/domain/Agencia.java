package znlipe.com.github.ProjetoBancario.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Agencia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany
  private List<Persona> clientes = new ArrayList<>();

  @OneToMany
  private List<ContaCorrente> contasCorrentes = new ArrayList<>();

  @OneToMany
  private List<ContaPoupanca> contasPoupancas = new ArrayList<>();

  @OneToMany(mappedBy = "idFunc")
  private List<Funcionario> funcionarios = new ArrayList<>();

  private String endereco;
  private String numero;


}
