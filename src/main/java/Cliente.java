import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
class Cliente {
    @Id
    private int id;
    private String nome;
    private String email;

    public Cliente() {}

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return nome + " (" + email + ")";
    }
}
