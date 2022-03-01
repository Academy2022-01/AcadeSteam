package it.unikey.acadesteam.BLL.mapper;

import it.unikey.acadesteam.BLL.dto.UserInfoDTO;
import it.unikey.acadesteam.DAL.entity.UserInfoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {
    UserInfoDTO fromUserInfoEntitytoUserInfoDto(UserInfoEntity entity);
    UserInfoEntity fromUserInfoDtotoUserInfoEntity(UserInfoDTO dto);
}
