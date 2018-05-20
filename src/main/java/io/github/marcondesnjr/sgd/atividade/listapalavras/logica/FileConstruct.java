/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.sgd.atividade.listapalavras.logica;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class FileConstruct {

    public static List<String> getPalavras(String url, String... identificadores) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException ex) {
            Logger.getLogger(FileConstruct.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<String> palavras = new ArrayList<>();
        for (String identificador : identificadores) {
            Elements el = doc.select(identificador);
            palavras.addAll(el.eachText());
        }
        List<String> resultList = new ArrayList<>();
        palavras.stream().map((element) -> element.split(" ")).forEachOrdered((arrayString) -> {
            resultList.addAll(Arrays.asList(arrayString));
        });

        return resultList;
    }

    public static void saveFile(List<String> palavras, Path p, boolean append) {
        final String newLine = System.getProperty("line.separator");
        if (!append && p.toFile().exists()) {
            p.toFile().delete();
        }
        palavras.forEach((palavra) -> {
            try {
                FileUtils.writeStringToFile(p.toFile(), palavra + newLine, StandardCharsets.UTF_8, true);
            } catch (IOException ex) {
                Logger.getLogger(FileConstruct.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
