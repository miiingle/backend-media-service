package net.miiingle.media.service


import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class UrlSignerServiceSpec extends Specification {

    @Inject
    UrlSignerService urlSigner

    void 'it was wired'() {
        expect:
        urlSigner
    }

    void 'it signs'() {
        when:
        def signedUrl = urlSigner.signUrl()

        then:
        signedUrl
    }

}
