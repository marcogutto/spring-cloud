package com.marcogutto.auth.config.mongodb;

import com.github.mongobee.Mongobee;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@DependsOn("mongoTemplate")
public class MongoBeeConfig {

	protected final Log logger = LogFactory.getLog(getClass());
	
    private static final String MONGODB_URL_FORMAT = "mongodb://%s:%s@%s:%d/%s";
    private static final String MONGODB_CHANGELOGS_PACKAGE = "com.marcogutto.auth.config.mongodb.changelogs";

    @Autowired
    private MongoProperties mongoProperties;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Bean
    public Mongobee mongobee() {
    	
    	logger.info(" RAW URL "+MONGODB_URL_FORMAT);
    	logger.info(" FULL URL "+String.format(MONGODB_URL_FORMAT,
                mongoProperties.getUsername(),
                "password",
                mongoProperties.getHost(),
                mongoProperties.getPort(),
                mongoProperties.getDatabase()));
    	
    	//TODO
        Mongobee runner = new Mongobee(String.format(MONGODB_URL_FORMAT,
                mongoProperties.getUsername(),
                "password",
                //mongoProperties.getPassword(),
                mongoProperties.getHost(),
                mongoProperties.getPort(),
                mongoProperties.getDatabase()));
        runner.setMongoTemplate(mongoTemplate);
        runner.setDbName(mongoProperties.getDatabase());
        runner.setChangeLogsScanPackage(MONGODB_CHANGELOGS_PACKAGE);
        return runner;
    }

}
