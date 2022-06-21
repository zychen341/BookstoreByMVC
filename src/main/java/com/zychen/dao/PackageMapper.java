package com.zychen.dao;

import com.zychen.pojo.Package;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PackageMapper {

    //查询
    List<Package> queryPackage();

    int addPackage(Package pack);

    //删除-->0
    int deletePackageById(@Param("id") int id);

    //删除-1
    int deletePackageById2(@Param("id") int id);

    //清空
    int clearPackageByAccount(String account);
}
