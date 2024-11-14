package com.DemoImageUploder.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.DemoImageUploder.Entity.Files;
import com.DemoImageUploder.Repository.FileRepository;

@Service
public class FilesService
{
	 @Autowired
     private FileRepository filerepository;
     
      public String storeFile(MultipartFile file) throws IOException
      {
           Files files=new Files();
                 files.setName(file.getOriginalFilename()); 
                 files.setType(file.getContentType());
                 files.setImageData(file.getBytes());
                 
                 filerepository.save(files);  
                 
                 return "Image added SucessFully";
      }


      public byte[] downloadImage(String name)
      {
         return filerepository.findByName(name).getImageData();
      }


}
