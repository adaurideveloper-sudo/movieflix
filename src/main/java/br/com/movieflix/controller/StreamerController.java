package br.com.movieflix.controller;


import br.com.movieflix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamerController {

    private final StreamingService streamingService;


}
