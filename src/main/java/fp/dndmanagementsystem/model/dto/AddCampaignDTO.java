package fp.dndmanagementsystem.model.dto;

import fp.dndmanagementsystem.model.entity.UserEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.PositiveOrZero;

public record AddCampaignDTO ( @NotNull String name,
                               @Size(message = "{add.offer.description.length}", min = 5,
                                       max = 500) String description,
                               @NotNull @PositiveOrZero UserEntity dungeonMaster)
{
        public static AddCampaignDTO empty() {
            return new AddCampaignDTO(null, null, null);
        }
}
