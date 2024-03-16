package znlipe.com.github.ProjetoBancario.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agency {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String name;

  @Column(unique = true, nullable = false, length = 4)
  private String number;

  @Column(nullable = false)
  @NotBlank //não pode ser em branco
  private String adress;

  @JsonIgnore //torna esse campo opcional para requisições https (geralmente listas são JsonIgnore)
  @OneToMany(mappedBy = "agency")
  private List<Persona> customers = new ArrayList<>();

  @JsonIgnore //torna esse campo opcional para requisições https (geralmente listas são JsonIgnore)
  @OneToMany(mappedBy = "agency")
  private Set<Employee> employees = new HashSet<>();

  @JsonIgnore //torna esse campo opcional para requisições https (geralmente listas são JsonIgnore)
  @OneToMany(mappedBy = "agency")
  private Set<CurrentAccount> currentAccounts = new HashSet<>();

  @JsonIgnore //torna esse campo opcional para requisições https (geralmente listas são JsonIgnore)
  @OneToMany(mappedBy = "agency")
  private Set<SavingAccount> savingAccounts = new HashSet<>();

}
