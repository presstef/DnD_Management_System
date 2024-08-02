package fp.dndmanagementsystem.model.dto.character;

import jakarta.validation.constraints.NotEmpty;

public record AddCharacterDTO(
        @NotEmpty String name,
                String race,
                String characterClass,
                String characterSubClass,
                int level,
                int hp,
                double money,
                int armorClass,
                int speed,
                int strength,
                int dexterity,
                int constitution,
                int intelligence,
                int wisdom,
                int charisma
) {
    public static AddCharacterDTO empty() {
        return new AddCharacterDTO(null,null,null, null,
                0,0,0.0,0,0,
                0,0,0,0,0,0);
    }
}
