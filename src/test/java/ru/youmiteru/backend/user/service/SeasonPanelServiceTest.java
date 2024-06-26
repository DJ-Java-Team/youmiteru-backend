package ru.youmiteru.backend.user.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import ru.youmiteru.backend.domain.Season;
import ru.youmiteru.backend.domain.User;
import ru.youmiteru.backend.fakeDomain.FakeDomainCreator;
import ru.youmiteru.backend.repositories.SeasonRepository;
import ru.youmiteru.backend.repositories.UserRepository;
import ru.youmiteru.backend.service.UserService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SeasonPanelServiceTest {

    @InjectMocks
    private UserService seasonPanelService;
    @Mock
    private SeasonRepository seasonRepository;
    @Mock
    private UserRepository userRepository;
    private Season fakeSeason;
    private User fakeUser;
    private Long season_id;
    private Long user_id;
    @BeforeEach
    void init(){
        fakeSeason = FakeDomainCreator.createFakeSeason();
        fakeUser = FakeDomainCreator.createFakeUser();
        season_id = fakeSeason.getId();
        user_id = fakeUser.getId();
    }

    @Test
    public void testAddFavorite_UserNotFound() {
        Long userId = 1L;
        Long seasonId = 1L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        HttpStatus result = seasonPanelService.addFavorite(userId, seasonId);

        assertEquals(HttpStatus.BAD_REQUEST, result);

        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, never()).save(any());
        verify(seasonRepository, never()).save(any());
    }

    @Test
    public void testAddFavorite_SeasonNotFound() {
        Long userId = 1L;
        Long seasonId = 1L;

        User user = new User();
        user.setId(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(seasonRepository.findById(seasonId)).thenReturn(Optional.empty());

        HttpStatus result = seasonPanelService.addFavorite(userId, seasonId);

        assertEquals(HttpStatus.BAD_REQUEST, result);

        verify(userRepository, times(1)).findById(userId);
        verify(seasonRepository, times(1)).findById(seasonId);
        verify(userRepository, never()).save(any());
        verify(seasonRepository, never()).save(any());
    }

    @Test
    void testAddFavoriteBadRequest(){
        HttpStatus httpStatus = seasonPanelService.addFavorite(season_id, user_id);

        assertEquals(httpStatus, HttpStatus.BAD_REQUEST);
    }

    @Test
    void testDeleteFavoriteOK(){
        HttpStatus httpStatus = seasonPanelService.deleteFavorite(season_id, user_id);

        assertEquals(httpStatus, HttpStatus.BAD_REQUEST);

    }
}
