package no.nav.pensjon.dsf;

import no.nav.pensjon.dsf.repository.DbPerson;
import no.nav.pensjon.dsf.repository.DbRepo;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;
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

	@Bean
    DataSource dataSource() throws SQLException {
        /*spring.datasource.url=jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=d26dbfl023.test.local)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=PRESYSCDU1)(INSTANCE_NAME=ccuf02)(UR=A)(SERVER=DEDICATED)))
        spring.datasource.username=PRESYS_CDU1
        spring.datasource.password=IWXAVIFEEofq
        spring.jpa.hibernate.ddl-auto=update*/
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser("PRESYS_CDU1");
        dataSource.setPassword("IWXAVIFEEofq");
        dataSource.setURL("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=d26dbfl023.test.local)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=PRESYSCDU1)(INSTANCE_NAME=ccuf02)(UR=A)(SERVER=DEDICATED)))");
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }
}
