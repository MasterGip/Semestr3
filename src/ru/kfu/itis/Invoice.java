package ru.kfu.itis;

/**
 * Created by mg on 27.12.14.
 */
public class Invoice {
    private int countNumber;
    private String dateStart;
    private double value;
    private String worker;
    private double tax;
    private String plus;
    private String customerINN;

    public Invoice(int countNumber,
                   String dateStart,
                   double value,
                   String worker,
                   double tax,
                   String plus,
                   String customerINN) {
        this.countNumber = countNumber;
        this.dateStart = dateStart;
        this.value = value;
        this.worker = worker;
        this.tax = tax;
        this.plus = plus;
        this.customerINN = customerINN;
    }

    public String getCountNumber() {
        return countNumber + "";
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getValue() {
        return value + "";
    }

    public String getWorker() {
        return (worker != null)? worker : " - ";
    }

    public String getTax() {
        return tax + "";
    }

    public String getPlus() {
        return plus;
    }

    public String getCustomerINN() {
        return customerINN;
    }
}
