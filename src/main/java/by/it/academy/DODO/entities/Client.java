package by.it.academy.DODO.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
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

    @NotEmpty(message = "Firstname cannot be null")
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstname;

    @NotEmpty(message = "Phone number cannot be null")
    @Pattern(regexp = "^\\+\\d{1,14}$", message = "Phone number should start with '+' and be no more than 15 long")
    @Column(name = "PHONE_NUMBER", nullable = false, updatable = false)
    private String phoneNumber;

    @Email(message = "Email should be valid")
    @Column(name = "EMAIL")
    private String email;

    @Past(message = "Date of birth should be in the past")
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
