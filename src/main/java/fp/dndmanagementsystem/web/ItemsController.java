package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {
    private final ItemService itemService;

    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    public String getAllItems(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "items";
    }
}
