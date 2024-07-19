package fp.dndmanagementsystem.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
public class UserRegistrationDTO {
    @NotEmpty
    @Size(min = 5, max = 20)
    private String username;

    @NotEmpty
    private String password;

    public UserRegistrationDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserRegistrationDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "UserRegistrationDTO{" +
                "username='" + username + '\'' +
                ", password='" + (password == null ? "N/A" : "[PROVIDED]") + '\'' +
                '}';
    }
}
