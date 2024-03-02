package ru.youmiteru.backend.util;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.extensibility.Tier;
import ru.youmiteru.backend.domain.Genre;
import ru.youmiteru.backend.domain.Season;
import ru.youmiteru.backend.domain.Title;
import ru.youmiteru.backend.repositories.GenreRepository;
import ru.youmiteru.backend.repositories.SeasonRepository;
import ru.youmiteru.backend.repositories.TitleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CatalogFilter {
    private final TitleRepository titleRepository;
    private final GenreRepository genreRepository;
    private final SeasonRepository seasonRepository;


    //----------Фильтрация для жанра
    public List<Title> filterTitleGenre(List<String> filter){
        List<Long> genreIds = filter.stream()
            .flatMap(name -> genreRepository.findByName(name).stream())
            .map(Genre::getId)
            .collect(Collectors.toList());

        List<Long> checkTitleIds = titleRepository.findTitleIdsByGenreIdsList(genreIds);

        List<Long> titleIds = checkTitleIds.stream()
            .filter(id -> titleRepository.findGenreIdsByTitleIds(id).stream()
                .filter(ids -> genreIds.contains(ids))
                .count() == genreIds.size())
            .collect(Collectors.toList());

        return titleRepository.findAllById(titleIds).stream()
            .distinct()
            .collect(Collectors.toList());
    }


    //----------Фильтрация для даты года
    public List<Title> filterTitleDate(List<Long> dates, List<Title> checkTitle){
        List<Title> necessaryTitle = (checkTitle != null ? checkTitle : titleRepository.findAllForFilter()).stream()
            .flatMap(title -> seasonRepository.findByTitle(title).stream())
            .filter(seasons -> dates.contains((long) seasons.getReleaseDate().getYear()))
            .map(Season::getTitle)
            .distinct()
            .collect(Collectors.toList());

        return necessaryTitle;
    }


    //----------Фильтрация формата аниме(фильм, сериал, OVA)
    public List<Title> filterTitleFormat(List<String> formats, List<Title> checkTitle){
        List<Title> necessaryTitle = (checkTitle != null ? checkTitle : titleRepository.findAllForFilter()).stream()
            .flatMap(title -> seasonRepository.findByTitle(title).stream())
            .filter(seasons -> formats.stream().anyMatch(format -> seasons.getAnimeFormat().toString().equalsIgnoreCase(format)))
            .map(Season::getTitle)
            .distinct()
            .collect(Collectors.toList());

        return necessaryTitle;
    }

    //----------Фильтрация статуса аниме (вышел, выходит, заброшен)
    public List<Title> filterTitleState(List<String> states, List<Title> checkTitle){
        List<Title> necessaryTitle = (checkTitle != null ? checkTitle : titleRepository.findAllForFilter()).stream()
            .flatMap(title -> seasonRepository.findByTitle(title).stream())
            .filter(seasons -> states.contains(seasons.getTitleState().toString()))
            .map(Season::getTitle)
            .distinct()
            .collect(Collectors.toList());

        return necessaryTitle;
    }

    //----------Фильтрация возраста (18+, 12+, 6+)
    public List<Title> filterTitleAgeRestriction(List<String> ageRestrictions,List<Title> checkTitle){
        List<Title> necessaryTitle = (checkTitle != null ? checkTitle : titleRepository.findAllForFilter()).stream()
            .flatMap(title -> seasonRepository.findByTitle(title).stream())
            .filter(seasons -> ageRestrictions.contains(seasons.getAgeRestriction()))
            .map(Season::getTitle)
            .distinct()
            .collect(Collectors.toList());

        return necessaryTitle;
    }

    //----------Фильтрация сезонов месяца(зима, осень, весна, лето)
    public List<Title> filterTitleYearSeason(List<String> yearSeasons,List<Title> checkTitle){
        List<Title> necessaryTitle = (checkTitle != null ? checkTitle : titleRepository.findAllForFilter()).stream()
            .flatMap(title -> seasonRepository.findByTitle(title).stream())
            .filter(seasons -> yearSeasons.contains(seasons.getYearSeason()))
            .map(Season::getTitle)
            .distinct()
            .collect(Collectors.toList());

        return necessaryTitle;
    }

}
