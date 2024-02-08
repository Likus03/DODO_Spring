package by.it.academy.DODO.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID idUser;

    @NotEmpty(message = "Login cannot be null")
    @Column(name = "LOGIN", nullable = false, unique = true, updatable = false)
    private String login;

    @NotEmpty(message = "Password cannot be null")
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "WORKER_ID", nullable = false, updatable = false)
    private Worker worker;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getIdUser(), user.getIdUser()) && Objects.equals(getLogin(), user.getLogin()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getWorker(), user.getWorker());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser(), getLogin(), getPassword(), getWorker());
    }
}
