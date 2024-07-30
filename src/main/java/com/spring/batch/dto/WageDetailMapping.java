package com.spring.batch.dto;

import com.spring.batch.entity.WageEntity;
import com.spring.batch.entity.WageReqEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class WageDetailMapping {

    private List<WageReqEntity> wageReqEnties;

    private List<WageEntity> wageEntities;
}
