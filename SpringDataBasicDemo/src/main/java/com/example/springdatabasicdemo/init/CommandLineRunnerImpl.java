package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.enums.Category;
import com.example.springdatabasicdemo.enums.Engine;
import com.example.springdatabasicdemo.enums.Role;
import com.example.springdatabasicdemo.enums.Transmission;
import com.example.springdatabasicdemo.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    CrudService<BrandDto, Integer> brandService;
    @Autowired
    CrudService <ModelDto, Integer> modelService;
    @Autowired
    CrudService <OfferDto, Integer> offerService;
    @Autowired
    CrudService <UserDto, Integer> userService;
    @Autowired
    CrudService <UserRoleDto, Integer> roleService;

    @Override
    public void run(String... args) throws Exception {

    }

    private void Init(){
        UserRoleDto rol1 = new UserRoleDto(1, Role.User);
        UserRoleDto rol2 = new UserRoleDto(2,Role.Admin);

        rol1 = roleService.register(rol1);
        rol2 = roleService.register(rol2);

        UserDto user1 = new UserDto(1,"john_doe", "password", "John", "Doe", true, "image.jpg", null, rol1, null, null);
        UserDto user2 = new UserDto(2,"johnNike", "password123", "John", "Doe", true, "johnNike.jpg", null, rol2, null, null);
        UserDto user3 = new UserDto(3,"kartoha", "adminPass", "Admin", "User", true, "kart.jpg", null, rol2, null, null);
        UserDto user4 = new UserDto(4,"Spider", "jane123", "Jane", "Doe", true, "Spider.jpg", null, rol1, null, null);
        UserDto user5 = new UserDto(5,"USA", "pass5", "User", "Five", true, "USA.jpg", null, rol1, null, null);

        user1 = userService.register(user1);
        user2 = userService.register(user2);
        user3 = userService.register(user3);
        user4 = userService.register(user4);
        user5 = userService.register(user5);

        BrandDto brand1 = new BrandDto(1, "Brand 1", null, null, null);
        BrandDto brand2 = new BrandDto(2, "Brand 2", null, null, null);
        BrandDto brand3 =new BrandDto(3, "Brand 3", null, null, null);
        BrandDto brand4 =new BrandDto(4, "Brand 4", null, null, null);
        BrandDto brand5 =new BrandDto(5, "Brand 5", null, null, null);


        brand1 = brandService.register(brand1);
        brand2 = brandService.register(brand2);
        brand3 = brandService.register(brand3);
        brand4 = brandService.register(brand4);
        brand5 = brandService.register(brand5);

        Date date1 = new Date();

        ModelDto model1 = new ModelDto(1, "Model 1",Category.Car, "model1.jpg", 2012, 2023, null, new Date(), brand1);
        ModelDto model2 = new ModelDto(2, "Model 2", Category.Truck, "model2.jpg", 2010, 2022, new Date(), new Date(), brand2);
        ModelDto model3 = new ModelDto(3, "Model 3", Category.Motorcycle, "model3.jpg", 2015, 2024, new Date(), new Date(), brand3);
        ModelDto model4 = new ModelDto(4, "Model 4", Category.Buss, "model4.jpg", 2008, 2021, new Date(), new Date(), brand4);
        ModelDto model5 = new ModelDto(5, "Model 5", Category.Car, "model5.jpg", 2017, 2025, new Date(), new Date(), brand5);


        model1 = modelService.register(model1);
        model2 = modelService.register(model2);
        model3 = modelService.register(model3);
        model4 = modelService.register(model4);
        model5 = modelService.register(model5);

        OfferDto offer1 = new OfferDto("Offer 1", Engine.GASOLINE, "offer1.jpg", 10000, BigDecimal.valueOf(20000), Transmission.MANUAL, 2022, model1, user1);
        OfferDto offer2 = new OfferDto("Offer 2", Engine.DIESEL, "offer2.jpg", 15000, BigDecimal.valueOf(25000), Transmission.AUTOMATIC, 2020, model2, user2);
        OfferDto offer3 = new OfferDto("Offer 3", Engine.GASOLINE, "offer3.jpg", 8000, BigDecimal.valueOf(18000), Transmission.MANUAL, 2021, model3, user3);
        OfferDto offer4 = new OfferDto("Offer 4", Engine.ELECTRIC, "offer4.jpg", 5000, BigDecimal.valueOf(30000), Transmission.AUTOMATIC, 2023, model4, user4);
        OfferDto offer5 = new OfferDto("Offer 5", Engine.HYBRID, "offer5.jpg", 12000, BigDecimal.valueOf(22000), Transmission.AUTOMATIC, 2022, model5, user5);

        offerService.register(offer1);
        offerService.register(offer2);
        offerService.register(offer3);
        offerService.register(offer4);
        offerService.register(offer5);
    }

}
