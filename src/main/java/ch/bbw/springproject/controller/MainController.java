package ch.bbw.springproject.controller;

import ch.bbw.springproject.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    private final List<Item> itemList = new LinkedList<>();
    private final Stats stats;
    private final Color color;
    private final UserList userList;
    private final User user;

    @Autowired
    public MainController(Stats stats, Color color, UserList userList, User user) {
        this.stats = stats;
        this.color = color;
        this.userList = userList;
        this.user = user;
    }

    @PostConstruct
    public void initItemList() {
        System.out.println("InitItemList is called...");
        Item item1 = new Item(1, "This is the first Item", "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.");
        Item item2 = new Item(2, "This is the second Item", "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.");
        itemList.add(item1);
        itemList.add(item2);
    }


    @RequestMapping("/")
    public String index(Model model) {
        userList.addUser(user.getId());
        stats.incrementViews();
        model.addAttribute("items", itemList);
        model.addAttribute("color", color);
        model.addAttribute("stats", stats);
        model.addAttribute("user_list", userList);
        return "index";
    }

    @RequestMapping("/item/{itemId}")
    public String itemDetailsPage(Model model, @PathVariable("itemId") int id) {
        stats.incrementViews();
        Optional<Item> item = itemList.stream().filter(i -> i.getId() == id).findFirst();
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
        } else {
            model.addAttribute("item", null);
        }
        return "itemDetailsPage";
    }

}