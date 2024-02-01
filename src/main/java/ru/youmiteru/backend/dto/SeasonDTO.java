package ru.youmiteru.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.youmiteru.backend.domain.TitleState;
import java.time.LocalDate;
import java.util.List;

public class SeasonDTO {
    private interface seasonId {
        @JsonProperty(value = "seasons_id")
        Long getSeasonId();
    }

    private interface imageUrl {
        @JsonProperty(value = "season_image_url")
        String getImageUrl();
    }

    private interface seasonName {
        @JsonProperty(value = "seasons_name")
        String getSeasonName();
    }

    private interface animeFormat {
        @JsonProperty(value = "anime_format")
        String getAnimeFormat();
    }

    private interface description {
        @JsonProperty(value = "seasons_description")
        String getDescription();
    }

    private interface releaseDate {
        @JsonProperty(value = "release_date")
        LocalDate getReleaseDate();
    }

    private interface titleId {
        @JsonProperty(value = "title_id")
        Long getTitleId();
    }

    private interface titleState {
        @JsonProperty(value = "title_id")
        TitleState getTitleState();
    }

    private interface ageRestriction {
        @JsonProperty(value = "age_restriction")
        String getAgeRestriction();
    }

    private interface yearSeason {
        @JsonProperty(value = "year_season")
        String getYearSeason();
    }


    public enum Response {;
        @NoArgsConstructor
        @AllArgsConstructor
        @Data
        public static class HomePage implements seasonId, seasonName, description, imageUrl {
            Long seasonId;
            String seasonName;
            String description;
            String imageUrl;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class ListHomePage {
            List<Response.HomePage> banners;
            List<Response.HomePage> announced_seasons;
            List<Response.HomePage> popular_seasons;
            List<Response.HomePage> recent_released_seasons;
        }
    }
}
