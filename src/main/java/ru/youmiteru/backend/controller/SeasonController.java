package ru.youmiteru.backend.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.youmiteru.backend.dto.SeasonDTO;
import ru.youmiteru.backend.service.SeasonService;

@RestController
@RequestMapping("/youmiteru")
@RequiredArgsConstructor
public class SeasonController {
    private static final Logger logger = LogManager.getLogger();
    private final SeasonService seasonService;

    @GetMapping("/all")
    public SeasonDTO.Response.ListHomePage getAllSeasons() {
    private static final Logger logger = LogManager.getLogger();

    @GetMapping("/all")
    public SeasonDTO.Response.ListHomePage getAllSeasons(){
        logger.info("Метод Контроллера getAllSeason делает запрос в сервис");
        return seasonService.getAllSeasonForHomePage();
    }

    @GetMapping("/season/{id}")
    private SeasonDTO.Response.SeasonPage getSeasonPage(@PathVariable Long id) {
        return seasonService.getSeasonPage(id);
    }
}
