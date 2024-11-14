package com.DemoImageUploder.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.DemoImageUploder.Service.FilesService;

@RestController
@RequestMapping("/api")
public class FilesController
{
	
	@Autowired
    private FilesService FilesService;
	

    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException
    {
          String response= FilesService.storeFile(file);
          return ResponseEntity.ok(response);
    }
    

    @GetMapping("/downloadImage/{filename}")
    public ResponseEntity<byte []> downloadImage(@PathVariable("filename") String fileName)
    {
            byte [] imageData=  FilesService.downloadImage(fileName);

            return ResponseEntity.status(HttpStatus.OK)
            		.contentType(MediaType.valueOf("image/png")).body(imageData);
    }
}

         

