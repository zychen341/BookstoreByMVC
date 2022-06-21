package com.zychen.service;

import com.zychen.pojo.Package;

import java.util.List;

public interface PackageService {
    //查询
    List<Package> queryPackage();

    int addPackage(Package pack);

    //删除-->0
    int deletePackageById(int id);

    //删除-1
    int deletePackageById2(int id);

    //清空
    int clearPackageByAccount(String account);
}
