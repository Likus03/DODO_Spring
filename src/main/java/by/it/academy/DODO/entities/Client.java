package by.it.academy.DODO.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLIENTS")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "FIRSTNAME", nullable = false)
    private String firstname;

    @Column(name = "PHONE_NUMBER", nullable = false, updatable = false)
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "BIRTHDAY", nullable = false, updatable = false)
    private LocalDate birthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(getId(), client.getId()) && Objects.equals(getFirstname(), client.getFirstname()) && Objects.equals(getEmail(), client.getEmail()) && Objects.equals(getBirthday(), client.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstname(), getEmail(), getBirthday());
    }
}
