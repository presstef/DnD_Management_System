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
    public String getAllCampaigns(Model model) {
        try {
            model.addAttribute("allCampaigns", campaignService.getAllCampaignsSummary());
        } catch (Exception e) {
            System.err.println("Error fetching campaigns: " + e.getMessage());
            model.addAttribute("errorMessage", "Unable to retrieve campaigns. Please try again later.");
            return null; // Redirect to a generic error page
        }
        return "campaigns";
    }

}
