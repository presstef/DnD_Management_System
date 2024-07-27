package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.model.dto.AddCampaignDTO;
import fp.dndmanagementsystem.service.CampaignService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    //TODO model attribute for the relations
//    @ModelAttribute("allEngineTypes")
//    public EngineTypeEnum[] allEngineTypes() {
//        return EngineTypeEnum.values();
//    }

    @GetMapping("/add")
    public String newCampaign(Model model) {

        if (!model.containsAttribute("addCampaignDTO")) {
            model.addAttribute("addCampaignDTO", AddCampaignDTO.empty());
        }

        return "campaign-add";
    }

    @PostMapping("add")
    public String createCampaign(
            @Valid AddCampaignDTO addCampaignDTO,
            BindingResult bindingResult,
            RedirectAttributes rAtt) {

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("addCampaignDTO", addCampaignDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.addCampaignDTO", bindingResult);
            return "redirect:/campaigns/add";
        }


        long newCampaignId = campaignService.createCampaign(addCampaignDTO);

        return "redirect:/campaigns/" + newCampaignId;
    }

    @GetMapping("/{id}")
    public String campaignDetails(@PathVariable("id") Long id,
                               Model model) {

        model.addAttribute("campaignDetails", campaignService.getCampaignDetails(id));

        return "details";
    }

    @DeleteMapping("/{id}")
    public String deleteCampaign(@PathVariable("id") Long id) {

        campaignService.deleteCampaign(id);

        return "redirect:/campaigns/all";
    }
}
