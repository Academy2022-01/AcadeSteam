package it.unikey.acadesteam.BLL.mapper;

import it.unikey.acadesteam.BLL.dto.UserInfoDto;
import it.unikey.acadesteam.DAL.entity.UserInfoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {
    UserInfoDto fromUserInfoEntitytoUserInfoDto(UserInfoEntity entity);
    UserInfoEntity fromUserInfoDtotoUserInfoEntity(UserInfoDto dto);
}
