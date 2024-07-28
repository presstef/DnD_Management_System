package fp.dndmanagementsystem.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserRegistrationDTO {
    @NotEmpty
    @Size(min = 5, max = 20)
    private String name;

    @NotEmpty
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserRegistrationDTO{" +
                "username='" + name + '\'' +
                ", password='" + (password == null ? "N/A" : "[PROVIDED]") + '\'' +
                '}';
    }
}
