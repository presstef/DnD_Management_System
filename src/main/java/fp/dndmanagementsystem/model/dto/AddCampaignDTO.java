package fp.dndmanagementsystem.model.dto;

import fp.dndmanagementsystem.model.entity.UserEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//TODO dungeonMaster
public record AddCampaignDTO (
        @NotEmpty String name,
        @NotNull(message = "{add.campaign.description.length}")
        @Size(message = "{add.campaign.description.length}",
                min = 5,
                max = 500) String description/*,
        @NotEmpty UserEntity dungeonMaster*/)
{
        public static AddCampaignDTO empty() {
            return new AddCampaignDTO(null, null/*, null*/);
        }
}
