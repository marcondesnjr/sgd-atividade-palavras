/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.sgd.atividade.listapalavras;

import io.github.marcondesnjr.sgd.atividade.listapalavras.logica.FileConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class Startup {
    
    public static void main(String[] args) throws IOException {
        String url = "http://www.ifpb.edu.br/cajazeiras/noticias/2018/05/justica-eleitoral-realizara-evento-no-campus-cajazeiras-sobre-a-importancia-do-voto";
        
        
        List<String> listPalavras = FileConstruct.getPalavras(url, ".documentFirstHeading", 
                ".documentDescription", "div[property=\"rnews:articleBody\"]");
        
        
        Path p = Paths.get("C:\\Users\\marco\\Desktop\\macro\\passfile.txt");
        
        
        FileConstruct.saveFile(listPalavras, p, false);
    }
    
}
