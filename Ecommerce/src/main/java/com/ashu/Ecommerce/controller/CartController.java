package com.ashu.Ecommerce.controller;

import com.ashu.Ecommerce.dto.CartDTO;
import com.ashu.Ecommerce.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    /*@ResponseBody tells Spring to directly write the return value of a method
    to the HTTP response body (usually in JSON format), instead of rendering a view.*/

    /*
     * In the below example, if we directly depend on the concrete class
     * (e.g., FakeStoreCategoryService), we would be violating the
     * Dependency Inversion Principle (DIP).
     *
     * DIP states that high-level modules should not depend on low-level modules;
     * both should depend on abstractions (interfaces or abstract classes).
     *
     * So instead of creating a direct dependency on a concrete class,
     * we depend on an abstraction — the interface ICategoryService.
     * This makes our controller loosely coupled, flexible, and easier to test or extend.
     */

    // ❌ Violates DIP — direct dependency on concrete class
    // private FakeStoreCategoryService iCategoryService;

    // ✅ Follows DIP — depends on abstraction (interface)
    @Autowired  //is a Field based dependency injection
    private final ICartService iCartService;




    /*
     * Constructor-based injection of ICategoryService.
     * Spring automatically finds the implementation of ICategoryService
     * (in this case, FakeStoreCategoryService, which is marked as a component),
     * creates its object, and injects it into this class.
     *
     * This automatic process performed by Spring is called **Dependency Injection (DI)**.
     * DI is a mechanism provided by the Spring Framework that allows us to easily
     * implement the **Dependency Inversion Principle (DIP)**.
     *
     * DI is a software design pattern where an object receives from an external source
     * rather than creating itself. Instead of class creating its own dependencies, they are "injected" into the class,
     * often through  its constructor, setter methods, or interfaces.
     *
     * Dependency = Objects that a class relies on to perform its function.
     * Injection = providing these dependencies to the class from an external source.
     * IOC = A broader principle where the control of object creation and management is inverted.
     * DI is a specific implementation of IOC.
     *
     * In case of multiple classes implementing the same interface,
     * we need to explicitly tell Spring which implementation to use.
     * This can be done using annotations like @Primary or @Qualifier.
     */
    public CartController(ICartService iCartService) {
        this.iCartService = iCartService;
    }


    @GetMapping
    public List<CartDTO> getAllCategories() throws IOException {
        return this.iCartService.getAllCarts();
    }

    @GetMapping("/{id}")
    public CartDTO getCartbyId(@PathVariable int id) throws IOException{
        return this.iCartService.getCartById(id);
    }
}


//new CategoryController(new FakeStoreCategoryService());