package com.zychen.controller;

import com.zychen.pojo.Package;
import com.zychen.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/package")
public class PackageController {

    @Autowired
    @Qualifier("PackageServiceImpl")
    private PackageService packageService;

    @RequestMapping("/showPackage")
    public String queryPackage(Model model){
        List<Package> packages = packageService.queryPackage();
        List<Package> packageList = new ArrayList<Package>();
        for (Package aPackage : packages) {
            if (aPackage.getAccount().equals(AccountController.onlyAccount)){
                packageList.add(aPackage);
            }
        }
        model.addAttribute("packageList",packageList);
        return "package";
    }

    //删除背包byid
    @RequestMapping("/deletePackageById")
    public String deletePackageById(int id,int bookQuanities){
        if (bookQuanities>=2){
            packageService.deletePackageById2(id);
            return "redirect:/package/showPackage";
        }
        packageService.deletePackageById(id);
        return "redirect:/package/showPackage";
    }
}
