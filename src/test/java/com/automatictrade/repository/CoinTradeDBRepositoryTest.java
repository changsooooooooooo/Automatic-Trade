package com.automatictrade.repository;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.automatictrade.dto.CoinTradeRecordDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@SpringBootTest
class CoinTradeDBRepositoryTest {

    @Autowired
    private CoinTradeDBRepository coinTradeDBRepository;

    @Test
    void insertTest() throws IOException, JSONException {
//        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(
//                "<access-key>",
//                "<secret-key>");
//        AmazonS3 amazonS3 = AmazonS3ClientBuilder
//                .standard()
//                .withRegion(Regions.AP_NORTHEAST_2)
//                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
//                .build();
//        ObjectMapper mapper = new ObjectMapper();
//        ObjectListing objectListing = amazonS3.listObjects("upbit-coin", "2021-09-25");
//        for(S3ObjectSummary obs: objectListing.getObjectSummaries()){
//            S3Object obj = amazonS3.getObject("upbit-coin", obs.getKey());
//            String string = StreamUtils.copyToString(obj.getObjectContent(), StandardCharsets.UTF_8);
//            if (string.length()!=0){
//                System.out.println(new JSONObject(string));
//                CoinTradeRecordDTO ctr = mapper.readValue(string, CoinTradeRecordDTO.class);
//                coinTradeDBRepository.save(ctr);
//            }
//        }
    }

}
