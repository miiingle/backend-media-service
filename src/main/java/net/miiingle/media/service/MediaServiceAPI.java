package net.miiingle.media.service;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller("media")
public class MediaServiceAPI {

    private final UrlSignerService service;

    @Get
    public String signUrl(@QueryValue String file) {
        return service.signUrl(file);
    }
}
