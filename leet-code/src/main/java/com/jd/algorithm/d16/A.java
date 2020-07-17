package com.jd.algorithm.d16;

import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class A {

    public static void main(String[] args) {
        String filePath="D:/谷歌下载/20200615103742数据项详细信息.xlsx";
        System.out.println(filePath.substring(filePath.lastIndexOf("/")+1));
    }
}
