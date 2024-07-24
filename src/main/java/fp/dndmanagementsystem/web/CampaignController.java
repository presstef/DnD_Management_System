package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.model.dto.AddCampaignDTO;
import fp.dndmanagementsystem.service.CampaignService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("add")
    public String createOffer(
            @Valid AddCampaignDTO addCampaignDTO,
            BindingResult bindingResult,
            RedirectAttributes rAtt) {

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("addCampaignDTO", addCampaignDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.addCampaignDTO", bindingResult);
            return "redirect:/campaigns/add";
        }


        campaignService.createCampaign(addCampaignDTO);

        return "redirect:/campaigns/all";
    }

    @GetMapping("/{id}")
    public String campaignDetails(@PathVariable("id") Long id,
                               Model model) {

        model.addAttribute("campaignDetails", campaignService.getCampaignDetails(id));

        return "details";
    }

    //TODO delete mapping
   /* @DeleteMapping("/{id}")
    public String deleteCampaign(@PathVariable("id") Long id) {

        campaignService.deleteCampaign(id);

        return "redirect:/campaign/all";
    }*/
}
