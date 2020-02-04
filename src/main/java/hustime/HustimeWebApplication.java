package hustime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
//@EntityScan(
//		basePackageClasses = {Jsr310JpaConverters.class},
//		basePackages = {"member"})
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication(exclude={MultipartAutoConfiguration.class})
public class HustimeWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(HustimeWebApplication.class, args);
		
	}

}
