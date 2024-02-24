package ru.youmiteru.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.youmiteru.backend.domain.Rating;
import ru.youmiteru.backend.repositories.RatingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;

    public Double getRating(Long id) {
        return ratingRepository.getRatingBySeasonId(id);
    }
}
