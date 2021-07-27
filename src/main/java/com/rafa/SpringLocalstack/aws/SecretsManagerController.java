package com.rafa.SpringLocalstack.aws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretsManagerController {
    private @Autowired SecretFetcherService secretFetcherService;

    @GetMapping("/secretsManager")
    public ResponseEntity<ResponseData> fetch(@RequestParam String secretName) {
        return new ResponseEntity<>(
            ResponseData.builder().data(secretFetcherService.fetch(secretName)).build(),
            HttpStatus.OK
        );
    }
}
