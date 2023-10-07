package com.example.mobilelele.service.implemetation;

import com.example.mobilelele.model.dto.BrandDTO;
import com.example.mobilelele.model.dto.ModelDTO;
import com.example.mobilelele.model.enitity.ModelEntity;
import com.example.mobilelele.repository.BrandRepository;
import com.example.mobilelele.repository.ModelRepository;
import com.example.mobilelele.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public BrandServiceImpl(ModelRepository modelRepository,
                            BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {

        return brandRepository.findAll()
                .stream()
                .map(brand -> new BrandDTO(
                        brand.getName(),
                        modelRepository.findAllByBrandId(brand.getId()).stream()
                                .map(model -> new ModelDTO(model.getId(), model.getName()))
                                .sorted(Comparator.comparing(ModelDTO::name))
                                .collect(Collectors.toList())
                ))
                .sorted(Comparator.comparing(BrandDTO::name))
                .collect(Collectors.toList());
    }
}
