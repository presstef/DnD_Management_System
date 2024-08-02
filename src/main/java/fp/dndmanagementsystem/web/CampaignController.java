package fp.dndmanagementsystem.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/campaigns")
public class CampaignController {

//    private static final Logger LOGGER = LoggerFactory.getLogger(CampaignController.class);
//    private final CampaignService campaignService;
//
//    public CampaignController(CampaignService campaignService) {
//        this.campaignService = campaignService;
//    }
//
//    @GetMapping("/add")
//    public String newCampaign(Model model) {
//
//        if (!model.containsAttribute("addCampaignDTO")) {
//            model.addAttribute("addCampaignDTO", AddCampaignDTO.empty());
//        }
//
//        return "campaign-add";
//    }
//
//    @PostMapping("/add")
//    public String createCampaign(
//            @Valid AddCampaignDTO addCampaignDTO,
//            BindingResult bindingResult,
//            RedirectAttributes rAtt) {
//
//        if(bindingResult.hasErrors()){
//            rAtt.addFlashAttribute("addCampaignDTO", addCampaignDTO);
//            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.addCampaignDTO", bindingResult);
//            return "redirect:/campaigns/add";
//        }
//
//
//        campaignService.createCampaign(addCampaignDTO);
//        return "redirect:/campaigns/all";
//    }
//
//    @GetMapping("/{id}")
//    public String campaignDetails(@PathVariable("id") Long id,
//                               Model model) {
//
//        model.addAttribute("campaignDetails", campaignService.getCampaignDetails(id));
//
//        return "details";
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteCampaign(@PathVariable("id") Long id) {
//
//        campaignService.deleteCampaign(id);
//
//        return "redirect:/campaigns/all";
//    }
}
