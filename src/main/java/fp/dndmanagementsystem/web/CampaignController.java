package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.model.dto.AddCampaignDTO;
import fp.dndmanagementsystem.service.CampaignService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/campaigns")
public class CampaignController {

    private final CampaignService campaignService;


    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/add")
   public String newCampaign(Model model){
        if (!model.containsAttribute("addCampaignDTO")) {
            model.addAttribute("addCampaignDTO", AddCampaignDTO.empty());
        }

        return "campaign-add";
    }
}
