package fp.dndmanagementsystem.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDTO {
    @NotEmpty
    @Size(min = 5, max = 20)
    private String username;

    @NotEmpty
    private String password;

    @Override
    public String toString() {
        return "UserRegistrationDTO{" +
                "username='" + username + '\'' +
                ", password='" + (password == null ? "N/A" : "[PROVIDED]") + '\'' +
                '}';
    }
}
