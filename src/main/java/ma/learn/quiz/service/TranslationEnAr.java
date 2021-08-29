package ma.learn.quiz.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TranslationEnAr {
    public String TranslationResult(String texttotranslate) throws IOException {
        Document doc = Jsoup.connect("https://translate.google.com/m?sl=en&tl=ar&hl=en&q=" +texttotranslate).get();
        String result = doc.select("div.result-container").text();
        return result;
    }
}
