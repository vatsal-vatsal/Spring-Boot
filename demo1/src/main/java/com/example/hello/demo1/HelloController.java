package com.example.hello.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

/**
 * Web Controller Class
 * 
 * This class handles HTTP requests and returns HTML web pages.
 * Spring MVC automatically maps HTTP requests to these methods and renders Thymeleaf templates.
 * 
 * @Controller - Marks this class as a Spring MVC controller
 *   - Returns view names that get resolved to HTML templates
 *   - Automatically works with Thymeleaf template engine
 *   - Perfect for serving web pages (not REST APIs)
 */
@Controller
public class HelloController {

    /**
     * Dependency Injection of UserRepository
     * 
     * @Autowired - Spring automatically injects UserRepository implementation
     *   - Spring finds bean of type UserRepository and injects it here
     *   - No need to create instance manually (new UserRepository())
     *   - Enables database operations without manual setup
     */
    @Autowired 
    private UserRepository userRepository;

    /**
     * Hello Page - Returns HTML greeting page
     * 
     * @GetMapping("/hello") - Maps HTTP GET requests to this method
     *   Example: http://localhost:8080/hello?name=John
     * 
     * @RequestParam - Binds HTTP query parameter to method parameter
     *   value="name" - Parameter name in URL
     *   defaultValue="World" - Default value if parameter not provided
     * 
     * @param name - Name parameter from URL query string
     * @param model - Spring MVC Model object to pass data to template
     * @return View name "hello" -> resolves to /templates/hello.html
     */
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
        // Add data to model for template rendering
        model.addAttribute("name", name);
        return "hello"; // Returns hello.html template
    }   
    
    /**
     * Goodbye Page - Returns HTML goodbye page
     * 
     * @GetMapping("/goodbye") - Maps GET requests to /goodbye path
     *   Example: http://localhost:8080/goodbye?name=John
     * 
     * @param name - Optional name parameter (defaults to "World")
     * @param model - Spring MVC Model object to pass data to template
     * @return View name "goodbye" -> resolves to /templates/goodbye.html
     */
    @GetMapping("/goodbye")
    public String sayGoodbye(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
        // Add data to model for template rendering
        model.addAttribute("name", name);
        return "goodbye"; // Returns goodbye.html template
    }

    /**
     * Users List Page - Shows all users in database
     * 
     * @GetMapping("/users") - Maps GET requests to /users path
     *   Example: http://localhost:8080/users
     * 
     * @param model - Spring MVC Model object to pass data to template
     * @return View name "users" -> resolves to /templates/users.html
     */
    @GetMapping("/users")
    public String listUsers(Model model) {
        // Get all users from database
        List<User> users = userRepository.findAll();
        
        // Add users list to model for template rendering
        model.addAttribute("users", users);
        return "users"; // Returns users.html template
    }

    /**
     * Add User Form Page - Shows form to add new user
     * 
     * @GetMapping("/add-user-form") - Maps GET requests to /add-user-form path
     *   Example: http://localhost:8080/add-user-form
     * 
     * @return View name "add-user-form" -> resolves to /templates/add-user-form.html
     */
    @GetMapping("/add-user-form")
    public String showAddUserForm() {
        return "add-user-form"; // Returns add-user-form.html template
    }

    /**
     * Add User Endpoint - Saves user to database via POST form
     * 
     * @PostMapping("/add-user") - Maps HTTP POST requests to this method
     *   Used by the form submission from add-user-form.html
     * 
     * @RequestParam String name - Required parameter from form
     * @RequestParam String email - Required parameter from form
     * @param redirectAttributes - For flash messages after redirect
     * @return Redirect to users list page
     */
    @PostMapping("/add-user")
    public String addUser(@RequestParam String name, @RequestParam String email, 
                         RedirectAttributes redirectAttributes) {
        try {
            // Create new User object
            User u = new User();
            
            // Set properties from form parameters
            u.setName(name);
            u.setEmail(email);
            
            // Save to database - userRepository.save() does SQL INSERT
            userRepository.save(u); 
            
            // Add success message for display on next page
            redirectAttributes.addFlashAttribute("message", "User '" + name + "' added successfully!");
            
        } catch (Exception e) {
            // Add error message if something goes wrong
            redirectAttributes.addFlashAttribute("error", "Error adding user: " + e.getMessage());
            redirectAttributes.addFlashAttribute("name", name);
            redirectAttributes.addFlashAttribute("email", email);
            return "redirect:/add-user-form";
        }
        
        return "redirect:/users"; // Redirect to users list page
    }
}