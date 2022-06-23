package app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import app.service.SortService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final SortService sortService;

    @GetMapping("/")
    public String mainPage() {
        return sortService.doSort(List.of(1, 5, 4, 2, 3)).toString();
    }
}


