package org.jspider.springmvccrud.controller;

import org.jspider.springmvccrud.domain.Mobile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class MobileController {
    List<Mobile> mobileList=new ArrayList<>();

    {
        mobileList.add(new Mobile("S2","SAMSUNG",25000.25));
        mobileList.add(new Mobile("C2","REALME",45000.25));
        mobileList.add(new Mobile("IPHONE 14","APPLE",85000.25));
    }
    @GetMapping("/")
    public String getMobiles(Model model){
        model.addAttribute("mobiles",mobileList);
        return "mobiles";
    }

    @GetMapping("/addmoibleform")
    public String getNewMobileForm(Model model){
        Mobile m1=new Mobile();
        model.addAttribute("mobile",m1);
        return "mobileform";
    }

    @PostMapping("/addmobile")
    public String addMobileDetails(Mobile mobile){
        mobileList.add(mobile);
        return "redirect:/";
    }
    @GetMapping("/updatemobile/{model}")
    public String getMobileUpdateForm(@PathVariable(value = "model") String modelName,Model m){
        for (Mobile m1:mobileList){
            if (m1.getModelName().equals(modelName)){
                m.addAttribute("mobile",m1);
            }
        }
        return "updatemobileform";
    }

    @PostMapping("/modifymobile")
    public String modifyMobile(Mobile mobile){
        for (int a=0;a<mobileList.size();a++){
                Mobile m=mobileList.get(a);
                if (m.getModelName().equals(mobile.getModelName())){
                    mobileList.set(a,mobile);
                }
        }
        return "redirect:/";
    }

    @GetMapping("/deletemobile/{model}")
    public String deleteMobile(@PathVariable(value = "model") String modelName){
        Iterator<Mobile> itr=mobileList.iterator();
        while (itr.hasNext()){
            if (itr.next().getModelName().equals(modelName)){
                itr.remove();
            }
        }
        return "redirect:/";
    }
}
