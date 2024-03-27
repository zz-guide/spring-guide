import org.junit.jupiter.api.Test;
import org.zz.config.ApplicationContextConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationTests {
    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

    @Test
    public void testAnnotationConfigApplicationContext() {

    }
}
