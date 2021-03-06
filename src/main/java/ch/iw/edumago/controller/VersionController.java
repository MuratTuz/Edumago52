package ch.iw.edumago.controller;

import ch.iw.edumago.model.VersionInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VersionController {

    @GetMapping("/version")
    public ResponseEntity<VersionInfo> getVersion() {

        try {
            return new ResponseEntity<VersionInfo>(new VersionInfo().get(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<VersionInfo>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<HttpStatus> checkHealth() {
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}
