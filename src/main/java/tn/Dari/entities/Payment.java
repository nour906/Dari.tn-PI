package tn.Dari.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private long id;
    @Column(nullable = false,updatable = false)
    private String invoice_code;
    @Column(nullable = false,updatable = false)
    private String payment_reference;
    private PaymentType type;
    private Date date;

}
