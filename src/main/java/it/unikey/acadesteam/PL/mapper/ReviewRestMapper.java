package it.unikey.acadesteam.PL.mapper;

import it.unikey.acadesteam.BLL.dto.ReviewDto;
import it.unikey.acadesteam.PL.rest.ReviewRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewRestMapper {
    ReviewDto fromReviewRestToReviewDto(ReviewRest reviewRest);
    ReviewRest fromReviewDtoToReviewRest(ReviewDto reviewDto);
}
