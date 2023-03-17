package voidX.project.hrMan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import voidX.project.hrMan.payload.response.ApiResponse;

@RestController
@RequestMapping("api/test")
public class TestController {

    @GetMapping("/getTestData")
    public ResponseEntity<Object> getTestData(){
        return ResponseEntity.ok().body(new ApiResponse(true,"success"));
    }
}
