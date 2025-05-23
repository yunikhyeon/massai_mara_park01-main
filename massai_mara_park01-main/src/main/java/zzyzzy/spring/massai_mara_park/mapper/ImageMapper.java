package zzyzzy.spring.massai_mara_park.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import zzyzzy.spring.massai_mara_park.model.Image;

import java.util.List;

@Mapper
public interface ImageMapper {

    @Select("SELECT * FROM images")
    List<Image> findAll();

    @Select("SELECT * FROM images WHERE imageid = #{imageId}")
    Image findById(Long imageId);

}
