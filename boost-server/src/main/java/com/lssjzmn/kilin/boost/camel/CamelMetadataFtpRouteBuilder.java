package com.lssjzmn.kilin.boost.camel;

import com.lssjzmn.kilin.boost.facility.DataHomeUtil;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

//@Component
public class CamelMetadataFtpRouteBuilder extends RouteBuilder {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${client.datas.sync}")
    private String isDataSync;

    @Value("${ftp.server.metadata.info}")
    private String ftpServer;
    private String downloadLocation;

    @Autowired
    CamelFtpProcessor camelFtpProcessor;

    @PostConstruct
    public void init() {
        downloadLocation = "file:" + DataHomeUtil.getDetectDataHome();
        logger.info("Camel metadata Ftp RouteBuilder inited\n" + " metadata downloadLocation:" + downloadLocation);
    }

    @Override
    public void configure() throws Exception {
        if (isDataSync.equals("true"))
            from(ftpServer).process(camelFtpProcessor).to(downloadLocation);
    }
}
