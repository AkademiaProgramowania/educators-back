package com.akademia.educators_back.controller;

import com.akademia.educators_back.exception.CategoryDoesNotExistException;
import com.akademia.educators_back.exception.ProblemDoesNotExistException;
import com.akademia.educators_back.service.impl.CategoryServiceImpl;
import com.akademia.educators_back.to.CategoryTo;
import com.akademia.educators_back.to.NewCategoryTo;
import com.akademia.educators_back.to.ProblemTo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling request on Category object.
 */
@RequestMapping("api/categories")
@RestController
@AllArgsConstructor
public class CategoryController {

    public CategoryServiceImpl categoryService;

    /**
     * Controller responsible for create a new Category object
     * @param newCategoryTo The NewCategoryTo is an object representing the new category.
     */
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void createCategory(@RequestBody @Valid NewCategoryTo newCategoryTo){
        categoryService.addCategory(newCategoryTo);
    }

    /**
     * Controller responsible for sending list of all Category objects.
     * @return response entity
     */
    @GetMapping("/list")
    public ResponseEntity<List<CategoryTo>> getCategories(){
        return ResponseEntity.ok().body(categoryService.getCategories());
    }

    /**
     * Cotroller responsible for get single Category with provided param.
     * @param id ID is unique number which represent every one category.
     * @return The CategoryTo witch unique ID
     * @throws Exception when there is no category which provided ID.
     */
    @GetMapping("/{id}")
    public CategoryTo findCategoryById(@PathVariable Long id){
        CategoryTo categoryTo;
        try {
            categoryTo = categoryService.getCategoryById(id);
        }catch (CategoryDoesNotExistException e){
            throw new ProblemDoesNotExistException(id);
        }
        return categoryTo;
    }

    /**
     * Controller responsible for update exist Category
     * @param categoryTo The CategoryTo is an object representing exist category.
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void changeExistingCategory(@RequestBody CategoryTo categoryTo){
        categoryService.updateCategory(categoryTo);
    }

    /**
     * Controller responsible for update exist Category
     * @param categoryTo The CategoryTo is an object representing exist category.
     */
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void removeCategory(@RequestBody CategoryTo categoryTo){
        categoryService.deleteCategory(categoryTo);
    }
}
