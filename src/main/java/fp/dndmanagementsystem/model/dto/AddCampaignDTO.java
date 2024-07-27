package fp.dndmanagementsystem.model.dto;

import fp.dndmanagementsystem.model.entity.UserEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

//TODO dungeonMaster
public record AddCampaignDTO (
        @NotEmpty String name,
        @NotEmpty(message = "{add.offer.description.not.empty}")
        @Size(message = "Description should be between 5 and 500 symbols.",
                min = 5,
                max = 500) String description/*,
        @NotEmpty UserEntity dungeonMaster*/)
{
        public static AddCampaignDTO empty() {
            return new AddCampaignDTO(null, null/*, null*/);
        }
}
