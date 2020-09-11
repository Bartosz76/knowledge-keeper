package bm.app.models;

import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Component
public class LinkToCheck {

    private int link_id;
    private String link_name;
    private Date added_on;
}
