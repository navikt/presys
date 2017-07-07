package no.nav.pensjon.presys.utils.ebcdic;

import no.nav.pensjon.dsf.domene.Person;
import static  no.nav.pensjon.presys.utils.ebcdic.TestPerson.createPerson;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TestdataGenerering {


    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Person [] personer = {
                createPerson("1", "Donald Duck", 12)
                        .withInntekter()
                        .withEtteroppgjorAfp()
                        .withUforehistorikk()
                        .get(),
                createPerson("2", "Fetter Anton", 12)
                        .withInntekter()
                        .get()
        };

        List<String> lines = new ArrayList<>();

        for (Person p : personer){
            AnnotationMapper.writeSegment(p, bos);

            String fnr = p.getFnr();
            String data = new String(Base64.getEncoder().encode(bos.toByteArray()), Charset.forName("UTF-8"));
            bos.reset();
            lines.add(fnr + ";" + data);
        }

        Path file = Paths.get("testpersoner.txt");
        Files.write(file, lines, Charset.forName("UTF-8"));

    }

}
