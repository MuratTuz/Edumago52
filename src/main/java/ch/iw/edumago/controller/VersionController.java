package ch.iw.edumago.controller;

import ch.iw.edumago.dto.VersionInfo;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;

@RestController
public class VersionController {

    @GetMapping("/version")
    public ResponseEntity<VersionInfo> getVersion() {

        try{
            URL versionJsonUrl = VersionController.class
                    .getClassLoader().getResource("static/version.json");

            VersionInfo info = null;

            String path = versionJsonUrl.getPath();

            File f = new File(path);
            if(f.exists() && !f.isDirectory()) {
                Gson gson = new Gson();

                info = gson.fromJson(new FileReader(path), VersionInfo.class);
                return new ResponseEntity<VersionInfo>(info, HttpStatus.OK);
            }
            return new ResponseEntity<VersionInfo>(HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            return new ResponseEntity<VersionInfo>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
