package com.spring.batch.processor;

import com.spring.batch.dto.WageDetailMapping;
import com.spring.batch.entity.DistinctReqId;
import com.spring.batch.entity.WageEntity;
import com.spring.batch.entity.WageReqEntity;
import com.spring.batch.repo.WageRepo;
import com.spring.batch.repo.WageRequestRepo;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WageRequestProcessor implements ItemProcessor<DistinctReqId, WageDetailMapping> {

    @Autowired
    private WageRepo wageRepo;

    @Autowired
    private WageRequestRepo wageRequestRepo;

    @Override
    public WageDetailMapping process(DistinctReqId item) throws Exception {

        System.out.println(item.toString());

        WageDetailMapping wageDetailMapping = new WageDetailMapping();

        List<WageReqEntity> reqlist = wageRequestRepo.findByRequestId(item.getRequestId());
        wageDetailMapping.setWageReqEnties(reqlist);

        List<WageEntity> list = new ArrayList<>();

        for (WageReqEntity entity: reqlist) {
            List<WageEntity> i =  wageRepo.findByCustomerId(entity.getCustomerId());

            list.addAll(i);
        }

        wageDetailMapping.setWageEntities(list);
        return wageDetailMapping;
    }
}
