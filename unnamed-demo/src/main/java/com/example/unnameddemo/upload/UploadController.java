package com.example.unnameddemo.upload;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

/**
 * 上传
 *
 * @author Gary
 * @date 2020/4/2 15:00
 **/
@RestController
public class UploadController {

    @PostMapping("/upload")
    public String upload(@RequestParam("name") MultipartFile file) throws IOException {

        String storeFile = storeFile(file);

        CsvReader reader = CsvUtil.getReader();
        CsvData data = reader.read(FileUtil.file(storeFile));
        List<CsvRow> rows = data.getRows();
        rows.forEach(row -> {
//            System.out.println(row.getRawList());
            if (row.get(1).equalsIgnoreCase("b1")){
                System.out.println(row.getRawList());
            }
        });

//        CsvWriter writer = CsvUtil.getWriter("/Users/Gary/Desktop/广告系统表1.csv", CharsetUtil.CHARSET_UTF_8);
//        List<String[]> list = new ArrayList<>();
//        for (int i = 0; i < 10000000; i++) {
//            list.add(new ExportRow((long) i, "aaa", new Date()).toString().split(","));
//        }
//        writer.write(list);
        return "success";
    }

    private String storeFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        System.out.println(file.getOriginalFilename());
        System.out.println(fileName);

        Path fileStorageLocation = Paths.get("/Users/Gary/upload");
        File directory = new File(fileStorageLocation.toString());
        boolean mkdirs = directory.mkdirs();
        Path targetLocation = fileStorageLocation.resolve(fileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return targetLocation.toString();
    }
}
