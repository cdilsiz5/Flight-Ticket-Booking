package com.renastech.FlightTicketBooking.file;


import com.renastech.FlightTicketBooking.configuration.AppConfiguration;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;
@Service
public class FileService {

    @Autowired
    AppConfiguration appConfiguration ;


    public String writeBase64EncodedStringToFile(String image) throws IOException {
        String fileName=genarateRandomName();
        File target = new File(appConfiguration.getUploadPath()+"/"+fileName);
        OutputStream outputStream = new FileOutputStream(target);
        byte [] base64Encoded= Base64.getDecoder().decode(image);
        outputStream.write(base64Encoded);
        outputStream.close();
        return fileName;
    }
    public String genarateRandomName(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public void deleteFile(String oldImageName) {
        if(oldImageName==null){
            return;
        }
        try {
            Files.deleteIfExists(Paths.get(appConfiguration.getUploadPath()+"/"+oldImageName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String detectType(String s) {
        Tika tika=new Tika();
        byte [] base64Encoded=Base64.getDecoder().decode(s);
        return tika.detect(base64Encoded);
    }
}
