package vasyl.stavinskyi.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlPagesController {

    @RequestMapping("welcome")
    public String start() {
        return "index.html";
    }

    @RequestMapping("menu")
    public String menu() {
        return "pages/main.html";
    }

    @RequestMapping("management")
    public String order_management() { return "pages/order_management.html"; }

    @RequestMapping("order-page")
    public String order() {
        return "order.html";
    }

    @RequestMapping("place-page")
    public String place() { return "place.html"; }

    @RequestMapping("product-page")
    public String product() {
        return "product.html";
    }

    @RequestMapping("restaurant-page")
    public String restaurant() {
        return "restaurant.html";
    }

    @RequestMapping("user-page")
    public String user() {
        return "user.html";
    }

    @RequestMapping("worker-page")
    public String worker() {
        return "worker.html";
    }

}
