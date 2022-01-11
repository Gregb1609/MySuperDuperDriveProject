package com.udacity.jwdnd.course1.cloudstorage.mappers;

import com.udacity.jwdnd.course1.cloudstorage.Model.File;
import com.udacity.jwdnd.course1.cloudstorage.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FileMapper {
    @Select("SELECT * FROM FILES WHERE userid = #{userId}")
    public List<File> getFiles(User user);

    @Insert("INSERT INTO FILES (userid,filename,contenttype,filesize) VALUES (#{userId},#{fileName},#{contentType},#{fileSize})")
    @Options(useGeneratedKeys = true, keyProperty = "fileid")
    public void upload(File file);
}
