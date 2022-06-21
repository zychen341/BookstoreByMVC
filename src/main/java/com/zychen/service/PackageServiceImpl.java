package com.zychen.service;

import com.zychen.dao.PackageMapper;
import com.zychen.pojo.Package;

import java.util.List;

public class PackageServiceImpl implements PackageService{
    private PackageMapper packageMapper;

    public void setPackageMapper(PackageMapper packageMapper) {
        this.packageMapper = packageMapper;
    }

    public List<Package> queryPackage() {
        return packageMapper.queryPackage();
    }

    public int addPackage(Package pack) {
        return packageMapper.addPackage(pack);
    }

    public int deletePackageById(int id) {
        return packageMapper.deletePackageById(id);
    }

    public int deletePackageById2(int id) {
        return packageMapper.deletePackageById2(id);
    }

    public int clearPackageByAccount(String account) {
        return packageMapper.clearPackageByAccount(account);
    }
}
