package it.unikey.acadesteam.BLL.service.impl;

import it.unikey.acadesteam.BLL.dto.ReviewDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.mapper.ReviewDtoMapper;
import it.unikey.acadesteam.BLL.service.CrudService;
import it.unikey.acadesteam.DAL.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService implements CrudService<ReviewDto> {

    private final ReviewDtoMapper reviewMapper;
    private final ReviewRepository reviewRepository;

    @Override
    public ReviewDto insert(ReviewDto dto) {
        return null;
    }

    @Override
    public ReviewDto getById(Integer id) throws NotFoundException {
        if (!reviewRepository.existsById(id)) {
            throw new NotFoundException("The review you're trying to get not found in DB");
        }
        return reviewMapper.fromReviewEntityToReviewDto(reviewRepository.getById(id));
    }

    @Override
    public List<ReviewDto> getAll() {
        return null;
    }

    @Override
    public ReviewDto update(ReviewDto dto) throws NotFoundException {
        return null;
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if (!reviewRepository.existsById(id)) {
                throw new NotFoundException("The review you're trying to delete not found in DB");
            }
            reviewRepository.deleteById(id);
        }

    }
