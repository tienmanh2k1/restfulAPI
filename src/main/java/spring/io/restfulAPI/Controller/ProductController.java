package spring.io.restfulAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.io.restfulAPI.Model.Product;
import spring.io.restfulAPI.Repository.ProductRepository;
import spring.io.restfulAPI.Service.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("api/product/")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("list")
    public List<Product> productList(){
        return productRepository.findAll();
    }

    @PostMapping("add")
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("getId/{id}")
    public Product getProductId(@PathVariable long id){
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found Product id :"+id));
    }

    @PutMapping("update/{id}")
    public Product updateProduct(@RequestBody Product newProduct,@PathVariable long id){
        return productRepository.findById(id).map(p->{
            p.setCode(newProduct.getCode());
            p.setName(newProduct.getName());
            p.setPrice(newProduct.getPrice());
            p.setImage(newProduct.getImage());
//            p.setCategory(newProduct.getCategory());
            return productRepository.save(p);
        }).orElseGet(()->{newProduct.setId(id);
            return productRepository.save(newProduct);
        });
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable long id){
        productRepository.deleteById(id);
    }
}
