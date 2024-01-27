package com.pack.authentication.api.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "payments")
public class PaymentEntity {

    // PaymentDatabaseSequence

    // PaymentSequenceNumberGeneratorService

    @Transient
    public static final String PAYMENT_SEQUENCE_NAME = "payment_sequence";

    @Id
    @MongoId
    private Integer paymentId;
    private String paymentType;
    private String paymentTypeMethod;
    private String paymentMethodDetails;
    private Double amount;
    private String transactionID;
    private String uniqueID;
    private String transactionDate;
    private Integer flightBookingId;


    // private String paymentTypeData_Id_Number_UserId_UPI_ID_UPI_NUMBER_IMPS_NEFT_RTGS;

}
