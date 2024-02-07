package medipol.edu.tr.yazilim.Market.Look;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/api/urunler")
public class Application {

    private final ProductService productService;

    public Application(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/stok-artir/{urunAdi}")
    public void stokArtir(@PathVariable String urunAdi) {
        productService.stokArtir(urunAdi);
    }

    @PostMapping("/stok-azalt/{urunAdi}")
    public void stokAzalt(@PathVariable String urunAdi) {
        productService.stokAzalt(urunAdi);
    }

    @GetMapping("/listele")
    public Map<String, Integer> urunVeStokListele() {
        return productService.urunVeStokListele();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        ProductService productService = context.getBean(ProductService.class);
        productService.stokArtir("Bilgisayar");
        productService.stokArtir("Telefon");
        productService.stokArtir("Televizyon");
    }
}