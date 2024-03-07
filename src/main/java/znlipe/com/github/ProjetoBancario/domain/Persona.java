package znlipe.com.github.ProjetoBancario.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

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
  private String password;

  @CPF(message = "CPF Inválido")
  private String cpf;

  @OneToOne
  private ContaCorrente contaCorrente;

  @OneToOne
  private ContaPoupanca poupanca;

  private LocalDate birthDay;
  private Character gender;
  private LocalDate whenCreated;
  private LocalDate lastLogin;
  //private List<String> chavePix = new ArrayList<>();

}
