package medipol.edu.tr.yazilim.Market.Look;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    private Map<String, Integer> urunStokMap = new HashMap<>();

    public ProductService() {
        // Örnek stok bilgileri
        urunStokMap.put("Urun1", 10);
        urunStokMap.put("Urun2", 20);
    }

    public void stokArtir(String urunAdi) {
        if (urunStokMap.containsKey(urunAdi)) {
            int mevcutStok = urunStokMap.get(urunAdi);
            urunStokMap.put(urunAdi, mevcutStok + 1);
        } else {
            urunStokMap.put(urunAdi, 1);
        }
    }

    public void stokAzalt(String urunAdi) {
        if (urunStokMap.containsKey(urunAdi)) {
            int mevcutStok = urunStokMap.get(urunAdi);
            if (mevcutStok > 0) {
                urunStokMap.put(urunAdi, mevcutStok - 1);
            } else {
                throw new RuntimeException("Stok zaten sıfır.");
            }
        } else {
            throw new RuntimeException("Ürün bulunamadı.");
        }
    }

    public Map<String, Integer> urunVeStokListele() {
        return urunStokMap;
    }
}
