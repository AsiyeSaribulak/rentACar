package kodlama.io.rentACar.business.concrete;

import kodlama.io.rentACar.business.abstracts.BrandService;

import kodlama.io.rentACar.business.requests.CreateBrandsRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;

import kodlama.io.rentACar.entities.concrete.Brand;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
    List<Brand> brands=new ArrayList<>();
    List<GetAllBrandsResponse> brandsResponse=new ArrayList<>();

        for (Brand brand: brands) {
            GetAllBrandsResponse responseItem= new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());

            brandsResponse.add(responseItem);
        }

        return brandsResponse;
    }

    @Override
    public void add(CreateBrandsRequest createBrandsRequest) {
        Brand brand=new Brand();
        brand.setName(createBrandsRequest.getName());
       this.brandRepository.save(brand);
    }
}
