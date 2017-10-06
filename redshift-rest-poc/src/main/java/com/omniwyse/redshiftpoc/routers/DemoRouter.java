package com.omniwyse.redshiftpoc.routers;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.omniwyse.redshiftpoc.RedShiftRestPOC;
import com.omniwyse.redshiftpoc.mappers.DemoMapper;
import com.omniwyse.redshiftpoc.services.FileService;

@Component
public class DemoRouter extends RouteBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedShiftRestPOC.class);

    @Autowired
    private DemoMapper mapper;

    @Autowired
    private FileService fileService;

    @Value("${camel.batch.timeout}")
    private long batchTimeout;

    @Value("${camel.batch.max.records}")
    private int maxRecords;

    @Value("${source.type}")
    private String sourceType;

    @Value("${source.location}")
    private String sourceLocation;

    @Value("${noop.flag}")
    private boolean isNoop;

    @Value("${recursive.flag}")
    private boolean isRecursive;

    @Value("${file.type}")
    private String fileType;


    @Override
    public void configure() throws Exception {

        LOGGER.info("MApping the file from file path to to file path *****************************  ");

        // BindyCsvDataFormat bindyCsvDataFormat = new
        // BindyCsvDataFormat(PersonCsvRecord.class);
        // bindyCsvDataFormat.setLocale("default");

        // from(buildFileUrl()).transacted().unmarshal(bindyCsvDataFormat).split(body()).streaming()
        // .bean(mapper, "convertAndTransform").aggregate(constant(true), new
        // ArrayListAggregationStrategy())
        // .completionPredicate(new
        // BatchSizePredicate(maxRecords)).completionTimeout(batchTimeout)
        // .bean(personService).to("bean:personService?method=findAll").end();
        
        // from("ftp://s3://ischool-sms/10/English/EASY?ftpClient.dataTimeout=30000").to

        from("direct:fileupload")
                .to("sftp://ischool-sms.s3.amazonaws.com:?username=Bhaskar&password=Bhaskar1!//ischool-sms/10/English/EASY?ftpClient.dataTimeout=30000");

        from("ftp://s3://ischool-sms/10/English/EASY?ftpClient.dataTimeout=30000 ")
                .process(new Processor() {
            
            @Override
            public void process(Exchange exchange) throws Exception {
                fileService.uploadFile(exchange.getIn().getBody(String.class));
            }
        });
       

    }

    // private String buildFileUrl() {
    // StringBuilder fileUrlBuilder = new StringBuilder();
    // return
    // fileUrlBuilder.append(sourceType).append(COLON).append(sourceLocation).append(QUESTION_MARK)
    // .append("noop=").append(isNoop).append(AMPERSAND).append("recursive=").append(isRecursive)
    // .append(AMPERSAND).append("include=").append(fileType).toString();
    // }

}
