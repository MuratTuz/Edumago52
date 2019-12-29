package ch.iw.edumago.controller;

import ch.iw.edumago.dto.VersionInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VersionController {

    @GetMapping("/version")
    public ResponseEntity<VersionInfo> getVersion() {

        try {
            String time = System.getenv("CODEBUILD_START_TIME");
            VersionInfo info = new VersionInfo();
            return new ResponseEntity<VersionInfo>(info.get(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<VersionInfo>(HttpStatus.NOT_FOUND);
        }
    }
}
