package com.lssjzmn.kilin.boost.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFileMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.RandomAccessFile;

public class CamelFtpProcessor implements Processor {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void process(Exchange exchange) throws Exception {
        GenericFileMessage<RandomAccessFile> inFileMessage = (GenericFileMessage<RandomAccessFile>) exchange.getIn();
        String fileName = inFileMessage.getGenericFile().getFileName();//文件名
        logger.info("download file:" + fileName);
    }
}
