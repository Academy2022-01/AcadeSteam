package it.unikey.acadesteam.BLL.mapper;

import it.unikey.acadesteam.BLL.dto.ReviewDto;
import it.unikey.acadesteam.DAL.entity.ReviewEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewDtoMapper {
    ReviewEntity fromReviewDtoToReviewEntity(ReviewDto reviewDto);
    ReviewDto fromReviewEntityToReviewDto(ReviewEntity reviewEntity);
}
