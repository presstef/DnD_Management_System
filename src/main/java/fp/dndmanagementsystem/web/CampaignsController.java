package fp.dndmanagementsystem.web;


import fp.dndmanagementsystem.service.CampaignService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/campaigns")
public class CampaignsController {

    private final CampaignService campaignService;

    public CampaignsController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/all")
    public String getAllOffers(Model model) {

        model.addAttribute("allCampaigns", campaignService.getAllCampaignsSummary());
        return "campaigns";
    }

}
