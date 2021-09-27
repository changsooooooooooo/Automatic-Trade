package com.automatictrade.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.automatictrade.config.AWSS3Config;
import com.automatictrade.dto.CoinTradeRecordDTO;
import com.automatictrade.exceptions.FunctionWithException;
import com.automatictrade.exceptions.TransferLogicException;
import com.automatictrade.repository.CoinTradeDBRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransferLogic {

    @Value("${aws.s3.bucket}")
    private String bucketName;

    private final ObjectMapper mapper;
    private final AWSS3Config awss3Config;
    private final CoinTradeDBRepository coinTradeDBRepository;

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void truncateDB(){
        coinTradeDBRepository.deleteAll();
    }

    public void saveToDB(){
        String date = simpleDateFormat.format(LocalDate.now());
        AmazonS3 amazonS3 = awss3Config.amazonS3();
        List<S3Object> s3ObjList = amazonS3.listObjects(bucketName, date)
                        .getObjectSummaries()
                        .stream()
                        .map(objSummary->amazonS3.getObject(bucketName, objSummary.getKey()))
                        .collect(Collectors.toList());

        saveContent(s3ObjList);
    }

    public void saveContent(final List<S3Object> s3ObjList) {
        s3ObjList.stream()
                .map(wrapper(s3Obj-> StreamUtils.copyToString(s3Obj.getObjectContent(), StandardCharsets.UTF_8)))
                .filter(str->0<str.length()&&str.getClass().equals(String.class))
                .map(wrapper(str->mapper.readValue(str, CoinTradeRecordDTO.class)))
                .filter(dto->dto.getClass().equals(CoinTradeRecordDTO.class))
                .forEach(dto->coinTradeDBRepository.save(dto));
    }

    private <T, R> Function<T, R> wrapper(final FunctionWithException<T, R> fe){
        return arg -> {
            try {
                return fe.apply(arg);
            } catch (Exception e) {
                throw new TransferLogicException("Check Transfer DB Service Logic", e.getCause());
            }
        };
    }

}
