package com.example.demo;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DemoController {

    final DemoService demoService;

    @GetMapping("/demo")
    public String getDemo() {
        return "demo";
    }

    @GetMapping("/name")
    public String getAName() {
        return demoService.gotName();
    }

    @GetMapping("/names")
    public List<String> getSomeNames() {
        return List.of(demoService.gotName(), demoService.gotName(), demoService.gotName());
    }

}
