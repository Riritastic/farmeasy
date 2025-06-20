package org.example.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    private String id;

    @NotEmpty(message = "El nombre de usuario no puede estar vacío.")
    @Size(min = 3, max = 20, message = "El nombre de usuario debe tener entre 3 y 20 caracteres.")
    @Indexed(unique = true)
    private String username;

    @NotEmpty(message = "La contraseña no puede estar vacía.")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres.")
    private String password; // Se almacenará hasheada

    @Email(message = "Debe ser una dirección de correo válida.")
    @NotEmpty(message = "El email no puede estar vacío.")
    @Indexed(unique = true)
    private String email;

    private Set<String> roles = new HashSet<>(); // Ejemplo: "ROLE_USER", "ROLE_ADMIN"

    private boolean enabled = true; // Para Spring Security
}