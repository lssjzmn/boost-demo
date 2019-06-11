package com.lssjzmn.kilin.boost.facility;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Iterator;

public class PicXmlObjParser {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private SAXReader saxReader = new SAXReader();

    private Document xmlDocument;

    private Element rootElement;

    public boolean initXml(String xmlPath) {
        if (new File(xmlPath).exists() && xmlPath.endsWith(".xml")) {
            try {
                xmlDocument = saxReader.read(new File(xmlPath));
                rootElement = xmlDocument.getRootElement();
                return true;
            } catch (DocumentException e) {
                logger.error("xmlDocument error:" + e.getMessage());
                return false;
            }
        }
        logger.error("xmlDocument error: file " + xmlPath + "does not exist!");
        return false;
    }

    public int calPictureNum() {
        int num = 0;
        Element picElement;
        for (Iterator picIterator = rootElement.elementIterator("Picture"); picIterator.hasNext(); ) {
            picElement = (Element) picIterator.next();
            num++;
        }
        return num;
    }

    public void assemblePictures() {
        Element picElement;
        for (Iterator picIterator = rootElement.elementIterator("Picture"); picIterator.hasNext(); ) {
            picElement = (Element) picIterator.next();
            doAssemble(picElement);
        }
    }

    private void doAssemble(Element picElement) {
        try {
            String fullName = picElement.attributeValue("name");
            String fullNames[] = fullName.split("\\\\");
            String picName = fullNames[fullNames.length - 1];
            String x = picElement.attributeValue("x");
            String y = picElement.attributeValue("y");
            String lon = picElement.attributeValue("longitude");
            String lat = picElement.attributeValue("latitude");
            String angle = picElement.attributeValue("angle");
            String md5 = picElement.attributeValue("md5");
        } catch (Exception e) {
            logger.error("PicXmlObjParser errors in ");
        }
    }

}
