# spring-batch-dynamic

import org.springframework.batch.item.ItemWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DetailItemWriter implements ItemWriter<Item> {

    private String outputDirectory;

    public DetailItemWriter(String outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    @Override
    public void write(List<? extends Item> items) throws Exception {
        for (Item item : items) {
            writeItemDetails(item);
        }
    }

    private void writeItemDetails(Item item) throws IOException {
        List<Detail> details = item.getDetails();
        for (int i = 0; i < details.size(); i++) {
            Detail detail = details.get(i);
            String fileName = String.format("%s/%s_detail_%d.txt", outputDirectory, item.getId(), (i + 1));
            Path path = Paths.get(fileName);
            
            // Ensure directory exists
            Files.createDirectories(path.getParent());

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writeFormattedDetail(writer, detail);
            }
        }
    }

    private void writeFormattedDetail(BufferedWriter writer, Detail detail) throws IOException {
        // Example formatting - adjust according to your Detail structure and requirements
        writer.write(String.format("Detail ID: %s\n", detail.getId()));
        writer.write(String.format("Name: %s\n", detail.getName()));
        writer.write(String.format("Description: %s\n", detail.getDescription()));
        writer.write(String.format("Value: %.2f\n", detail.getValue()));
        writer.write(String.format("Date: %s\n", detail.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE)));
        // Add more formatted fields as needed
    }
}

INSERT INTO springbatchdb.t_wage_req (ID, REQ_ID, CUSTOMER_ID) VALUES (1, 'CPD', 1);
INSERT INTO springbatchdb.t_wage_req (ID, REQ_ID, CUSTOMER_ID) VALUES (2, 'CPD', 2);
INSERT INTO springbatchdb.t_wage_req (ID, REQ_ID, CUSTOMER_ID) VALUES (3, 'CPP', 3);


INSERT INTO springbatchdb.t_wage (ID, pd_mth, wage_amount, CUSTOMER_ID) VALUES (1, 1, 100, 1);
INSERT INTO springbatchdb.t_wage (ID, pd_mth, wage_amount, CUSTOMER_ID) VALUES (2, 2, 200, 2);
INSERT INTO springbatchdb.t_wage (ID, pd_mth, wage_amount, CUSTOMER_ID) VALUES (3, 3, 300, 3);
INSERT INTO springbatchdb.t_wage (ID, pd_mth, wage_amount, CUSTOMER_ID) VALUES (4, 4, 400, 1);
INSERT INTO springbatchdb.t_wage (ID, pd_mth, wage_amount, CUSTOMER_ID) VALUES (5, 5, 500, 2);
INSERT INTO springbatchdb.t_wage (ID, pd_mth, wage_amount, CUSTOMER_ID) VALUES (6, 6, 600, 1);
INSERT INTO springbatchdb.t_wage (ID, pd_mth, wage_amount, CUSTOMER_ID) VALUES (7, 7, 700, 1);



