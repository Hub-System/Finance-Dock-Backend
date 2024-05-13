package com.finance_dock.finance_dock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootApplication
@Controller
public class FinanceDockApplication {

	@GetMapping("/")
    public RedirectView redirectToSpecificUrl() {
        return new RedirectView("https://finance-dock-frontend.onrender.com");
    }

	public static void main(String[] args) {
		SpringApplication.run(FinanceDockApplication.class, args);
	}

}
