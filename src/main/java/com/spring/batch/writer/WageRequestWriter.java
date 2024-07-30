package com.spring.batch.writer;

import com.spring.batch.dto.WageDetailMapping;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WageRequestWriter implements ItemWriter<WageDetailMapping> {
    @Override
    public void write(List<? extends WageDetailMapping> items) throws Exception {

        for (WageDetailMapping item : items) {
            System.out.println(item);
        }
    }
}
