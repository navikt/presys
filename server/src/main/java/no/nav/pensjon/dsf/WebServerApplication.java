package no.nav.pensjon.dsf;

import no.nav.pensjon.dsf.repository.DbPerson;
import no.nav.pensjon.dsf.repository.DbRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Base64;
import java.util.Scanner;

@SpringBootApplication
public class WebServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(WebServerApplication.class, args);
        DbRepo repo = context.getBean(DbRepo.class);
        String all = new Scanner(WebServerApplication.class.getResourceAsStream("/testpersoner.txt"), "UTF-8").useDelimiter("\\A").next();

        for (String one : all.split("\n")){
            if (one.charAt(one.length()-1) == '\r'){
                one = one.substring(0, one.length()-1);
            }
            String [] oneSplit = one.split(";");
            DbPerson p = new DbPerson();
            p.setFnr(oneSplit[0]);
            p.setData(oneSplit[1]);
            Base64.getDecoder().decode(p.getData());
            repo.save(p);
        }


	}
}
