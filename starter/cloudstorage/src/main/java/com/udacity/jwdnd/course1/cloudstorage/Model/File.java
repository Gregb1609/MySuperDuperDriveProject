package com.udacity.jwdnd.course1.cloudstorage.Model;

import org.springframework.web.multipart.MultipartFile;

public class File {
    Integer fileId,userId;
    String fileName,contentType,fileSize;
    MultipartFile uploadFile; //CAUTION POSSIBLE INCORRECT DATATYPE!
}
