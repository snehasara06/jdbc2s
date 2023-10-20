package com.kgisl.springJdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Configuration
@RequestMapping("/")
// @RequestMapping("/api")
public class CarController {

    // automatic dependency injection
    @Autowired
    CarDAO carDao;
    // CarRepository carRepo;

    @RequestMapping("/add")
    public String showCar(Model m) {
        m.addAttribute("command", new Car());
        return "add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute("car") Car car) {
        carDao.save(car);
        return "redirect:/view";
    }
    
    @RequestMapping("/view")
    public String viewCar(Model m){
        List<Car> carList=carDao.getCars();
        m.addAttribute("carList", carList);
        return "view";
    }
    @RequestMapping("/edit/{id}")
    public String editCar(@PathVariable int id,Model m)
    {
        Car c=carDao.getCarById(id);
        m.addAttribute("command", c);
        return "edit";
    }
    @RequestMapping(value="/editSave",method =RequestMethod.POST)
    public String editSave(@ModelAttribute("car") Car c){
        carDao.update(c);
        return "redirect:/view";
    }
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        carDao.delete(id);
        return "redirect:/view";
    }

}