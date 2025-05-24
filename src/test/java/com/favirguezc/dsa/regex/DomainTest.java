package com.favirguezc.dsa.regex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DomainTest {

    @Test
    void test1() {
        String line = "<li id=\"cite_note-1\"><span class=\"mw-cite-backlink\"><b>^ [\"Train (noun)\"](http://www.askoxford.com/concise_oed/train?view=uk). <i>(definition – Compact OED)</i>. Oxford University Press<span class=\"reference-accessdate\">. Retrieved 2008-03-18</span>.</span><span title=\"ctx_ver=Z39.88-2004&rfr_id=info%3Asid%2Fen.wikipedia.org%3ATrain&rft.atitle=Train+%28noun%29&rft.genre=article&rft_id=http%3A%2F%2Fwww.askoxford.com%2Fconcise_oed%2Ftrain%3Fview%3Duk&rft.jtitle=%28definition+%E2%80%93+Compact+OED%29&rft.pub=Oxford+University+Press&rft_val_fmt=info%3Aofi%2Ffmt%3Akev%3Amtx%3Ajournal\" class=\"Z3988\"><span style=\"display:none;\"> </span></span></span></li>";
        List<String> domains = Domain.find(line);
        assertEquals(1, domains.size());
        assertEquals("askoxford.com", domains.get(0));
    }

    @Test
    void test2() {
        String line = "<div class='footerhome' >&#169; 2013 <a href=\"http://ia.rediff.com/\" title=\"Rediff.com US\" >Rediff.com US</a> - <a id=\"mobicon\" href=\"javascript:;;\" onmouseover=\"findPosXY('mobicon','mobtip',-150,-65);\" onmouseout=\"hideDiv1('mobtip');\" >On Mobile</a> - <a href=\"http://investor.rediff.com/\">Investors</a> - <a href=\"http://clients.rediff.com/rediff_advertisewithus/contact.htm\">Advertise</a> - <a href=\"http://www.rediff.com/disclaim.htm\">Disclaimer</a> - <a href=\"http://www.rediff.com/w3c/policy.html\">Privacy</a> - <a href=\"http://careers.rediff.com/jobs/\">Careers</a> - <a href=\"http://www.rediff.com/sitemap.xml\"  title=\"Sitemap.xml\">Sitemap</a> - <a href=\"http://mypage.rediff.com/feedback\">Feedback</a> - <a href=\"http://www.rediff.com/terms.html\">Terms of use</a></div>";
        List<String> domains = Domain.find(line);
        assertEquals(6, domains.size());
        assertEquals("careers.rediff.com", domains.get(0));
        assertEquals("clients.rediff.com", domains.get(1));
        assertEquals("ia.rediff.com", domains.get(2));
        assertEquals("investor.rediff.com", domains.get(3));
        assertEquals("mypage.rediff.com", domains.get(4));
        assertEquals("rediff.com", domains.get(5));
    }

    @Test
    void test3() throws Exception {
        Path file = Path.of("", "src/test/resources/regex").resolve("domain1");
        String content = Files.readString(file);
        List<String> domains = Domain.find(content);
        assertEquals(List.of(
                "b.scorecardresearch.com",
                "books.rediff.com",
                "careers.rediff.com",
                "clients.rediff.com",
                "datastore.rediff.com",
                "datastore01.rediff.com",
                "datastore04.rediff.com",
                "datastore05.rediff.com",
                "dealhojaye.rediff.com",
                "hosting.rediff.com",
                "ia.rediff.com",
                "im.rediff.com",
                "imshopping.rediff.com",
                "imworld.rediff.com",
                "investor.rediff.com",
                "ishare.rediff.com",
                "loc.rediff.com",
                "login.rediff.com",
                "mail.rediff.com",
                "metric.ind.rediff.com",
                "money.rediff.com",
                "mypage.rediff.com",
                "n01.rcdn.in",
                "news.rediff.com",
                "pages.rediff.com",
                "realtime.rediff.com",
                "rediff.com",
                "register.rediff.com",
                "search.rediff.com",
                "shopping.rediff.com",
                "simg.rcdn.in",
                "simg03.rcdn.in",
                "track.rediff.com",
                "w3.org",
                "zarabol.rediff.com"),
                domains);
    }

    @Test
    void test4() throws Exception {
        Path file = Path.of("", "src/test/resources/regex").resolve("domain2");
        String content = Files.readString(file);
        List<String> domains = Domain.find(content);
        assertEquals(List.of(
                "ads.indiatimes.com",
                "ads2book.com",
                "adscontent2.indiatimes.com",
                "advertise.indiatimes.com",
                "ahmedabadmirror.com",
                "astrospeak.com",
                "b.scorecardresearch.com",
                "bangaloremirror.com",
                "base.google.com",
                "boxtv.com",
                "brandcapital.co.in",
                "cmstrendslog.indiatimes.com",
                "content.magicbricks.com",
                "download.macromedia.com",
                "economictimes.indiatimes.com",
                "email.indiatimes.com",
                "entertainment.timesofindia.com",
                "epaper.timesofindia.com",
                "facebook.com",
                "files.adspdbl.com",
                "gaana.com",
                "gogreenindia.co.in",
                "graph.facebook.com",
                "gujarati.economictimes.indiatimes.com",
                "guylife.com",
                "healthmeup.com",
                "hindi.economictimes.indiatimes.com",
                "hotklix.com",
                "ibeat.indiatimes.com",
                "idiva.com",
                "indiatimes.com",
                "itn.ph.affinity.com",
                "itsmyascent.com",
                "luxpresso.com",
                "m.timesofindia.com",
                "macromedia.com",
                "magicbricks.com",
                "maharashtratimes.indiatimes.com",
                "mobile.indiatimes.com",
                "mocolife.com",
                "mumbaimirror.com",
                "myeducationtimes.com",
                "myt.indiatimes.com",
                "mytimes.indiatimes.com",
                "navbharattimes.indiatimes.com",
                "netspiderads2.indiatimes.com",
                "netspiderads3.indiatimes.com",
                "netspideradswc.indiatimes.com",
                "ogp.me",
                "photogallery.indiatimes.com",
                "plus.google.com",
                "profile.live.com",
                "punemirror.in",
                "s3.amazonaws.com",
                "salescrm.indiatimes.com",
                "shopping.indiatimes.com",
                "simplymarry.com",
                "ssl.gstatic.com",
                "static.rewards.indiatimes.com",
                "tags.crwdcntrl.net",
                "techgig.com",
                "technoholik.com",
                "tenders.indiatimes.com",
                "timescity.com",
                "timescontent.com",
                "timescrest.com",
                "timesdeal.com",
                "timesinternet.in",
                "timesjobs.com",
                "timeslog.indiatimes.com",
                "timesnow.live.indiatimes.com",
                "timesnow.tv",
                "timesofindia.hotklix.com",
                "timesofindia.indiatimes.com",
                "timesofindia.speakingtree.in",
                "timesofmoney.com",
                "timestrends.indiatimes.com",
                "twitter.com",
                "vijaykarnataka.indiatimes.com",
                "w3.org",
                "webuild.indiatimes.com",
                "widgets.outbrain.com",
                "ww.itimes.com",
                "yolist.com",
                "zigwheels.com",
                "zoomtv.in"),
                domains);
    }

    @Test
    void test5() throws Exception {
        Path file = Path.of("", "src/test/resources/regex").resolve("domain3");
        String content = Files.readString(file);
        List<String> domains = Domain.find(content);
        assertEquals(List.of(
                "coursera-placement-resumes.s3.amazonaws.com",
                "coursera.org",
                "d2wvvaown1ul17.cloudfront.net",
                "eventing.coursera.org",
                "linkedin.com",
                "ogp.me",
                "s3.amazonaws.com",
                "schema.org",
                "ssl.google-analytics.com",
                "thelearningpoint.net"),
                domains);
    }
}
