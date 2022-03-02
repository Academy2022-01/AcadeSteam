package it.unikey.acadesteam.BLL.mapper;

import it.unikey.acadesteam.BLL.dto.ReviewDto;
import it.unikey.acadesteam.DAL.entity.ReviewEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewEntity fromReviewDtoToReviewEntity(ReviewDto reviewDto);
    ReviewDto fromReviewEntityToReviewDto(ReviewEntity reviewEntity);
}
