package config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class EnvironmentProperties {
    private static Logger logger = LoggerFactory.getLogger(EnvironmentProperties.class);
    private final String APP_ENV;

    public static EnvironmentProperties getInstance() {
        return EnvironmentProperties.EnvironmentPropertySingleton.INSTANCE;
    }

    private static class EnvironmentPropertySingleton {
        private static final EnvironmentProperties INSTANCE = new EnvironmentProperties();
    }

    private EnvironmentProperties() {
        this.APP_ENV = initAppEnv();
        this.initEnv();
    }

    private void initEnv() {
        if (!this.APP_ENV.isEmpty()) {
            logger.debug("Environment name " + this.APP_ENV);
            loadAllPropertiesToSystem(this.APP_ENV);
        } else {
            logger.error("Please provide environment property");
            assertThat(true).isEqualTo(false);
        }
    }

    private static void loadAllPropertiesToSystem(String app_env) {
        setSystemPropertiesFromPathUrl(app_env);
    }

    // set list of properties from env property file to System PRoperties
    private static void setSystemPropertiesFromPathUrl(String dirName) {
        URL url = EnvironmentProperties.class.getClassLoader().getResource(dirName);
        if (url != null) {
            Properties environmentProperties = new Properties();

            try {
                Stream<Path> files = Files.walk(Paths.get(url.toURI()));


                try {
                    ((List) files.filter((x$0) -> {
                        return Files.isRegularFile(x$0, new LinkOption[0]);
                    }).collect(Collectors.toList())).forEach((path) -> {
                        try {
                            environmentProperties.load(new FileInputStream(path.toString()));
                        } catch (IOException var3) {
                            logger.error("error 1");

                        }

                    });
                } catch (Exception e) {
                    logger.error("error 2");

                } finally {
                    if (files != null) {
                        try {
                            files.close();
                        } catch (Throwable var13) {
                            logger.error("error 3");
                        }
                    } else {
                        files.close();
                    }
                }

            } catch (Exception r) {
                logger.error("error 4");

            }

            logger.debug("#### Loading property from uri {}", url.toString());
            environmentProperties.forEach((propertyName, propertyValue) -> {
                if (System.getProperty(propertyName.toString()) == null) {
                    System.setProperty(propertyName.toString(), propertyValue.toString());
                    logger.debug("****Loading environment property {} = {} ", propertyName.toString(), propertyValue.toString());
                }

            });
            logger.debug("#### Properties loaded from {} : {} ", dirName, environmentProperties.size());
        } else {
            logger.warn("No such property directory '{}' present in the resources ,make sure you are providing correct directory name.", dirName);
        }

    }

    private static String initAppEnv() {
        return PropertiesStore.ENVIRONMENT.isSpecified() ? PropertiesStore.ENVIRONMENT.getValue() : "";
    }

}
