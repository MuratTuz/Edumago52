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

        /*
        VersionInfo info = null;

        try{
            ApplicationContext context
                    = new ClassPathXmlApplicationContext();

                Resource file = context.getResource("classpath:/version.json");

                if (file.exists())
                {
                    Gson gson = new Gson();

                    info = gson.fromJson(new FileReader(file.getFile().getPath()), VersionInfo.class);
                    return new ResponseEntity<VersionInfo>(info, HttpStatus.OK);
                }
            info = new VersionInfo();
            info.setBuildId("There was an error: path not found");
            return new ResponseEntity<VersionInfo>(info, HttpStatus.OK);
        } catch (IOException e) {
            info = new VersionInfo();
            info.setBuildId("There was an error: " + e.getMessage());
            return new ResponseEntity<VersionInfo>(info, HttpStatus.OK);
        }
         */
        return new ResponseEntity<>(new VersionInfo(), HttpStatus.OK);
    }
}
