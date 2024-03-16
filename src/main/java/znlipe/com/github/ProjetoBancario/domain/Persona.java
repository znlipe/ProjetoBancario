package znlipe.com.github.ProjetoBancario.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import znlipe.com.github.ProjetoBancario.domain.enums.TypeKey;

@Data //Cria todos os Getters and Setters
@Builder //Permite criação de um objeto de forma static
@Entity
@NoArgsConstructor //Cria um construtor sem argumentos
@AllArgsConstructor //Cria um construtor com argumentos
public class Persona {

  @Id //Define qual é a primary key do banco de dados
  @GeneratedValue(strategy = GenerationType.IDENTITY) //define o tipo de gerador
  private Long id;

  @Column(name = "name", nullable = false) //define o nome da coluna e proibe do dado ser nulo
  private String name;

  @Email(message = "Email rejeitado")
  private String email;

  @Column(nullable = false)
  @JsonIgnore
  private String password;

  @CPF(message = "CPF Inválido")
  private String cpf;

  @ManyToOne
  @JoinColumn(name = "agency_id")
  private Agency agency;

  private Integer typeKey;

  @Column(length = 1)
  private Character gender;

  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime birthDay;

  @JsonIgnore
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime lastLogin;

  @JsonIgnore
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime whenCreated;

  @JsonIgnore
  @OneToMany(mappedBy = "persona")
  private List<SavingAccount> savingAccounts = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "persona")
  private List<CurrentAccount> currentAccount = new ArrayList<>();

  @ElementCollection
  @CollectionTable(name = "PIX_KEYS")
  private Set<String> pixKeys;

  public TypeKey getTypeKey() {
    return TypeKey.toEnum(this.typeKey);
  }

  public void setTypeKey(TypeKey typeKey) {
    this.typeKey = typeKey.getCod();
  }
}
