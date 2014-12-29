package ru.kfu.itis;

/**
 * Created by mg on 27.12.14.
 */
public class Customer {
    private String iNN;
    private String customer;
    private boolean customerSign;
    private String addressCust;
    private String chief;
    private String bankCustomer;
    private String phone;
    private String district;
    private String accountCust;

    public String getiNN() {
        return iNN;
    }

    public String getCustomer() {
        return customer;
    }

    public String getCustomerSign() {
        return (customerSign)? "Юридическое лицо" : "Физическое лицо";
    }

    public String getAddressCust() {
        return (addressCust!=null)? addressCust : " - ";
    }

    public String getChief() {
        return (chief!=null)? chief : " - ";
    }

    public String getBankCustomer() {
        return (bankCustomer!=null)? bankCustomer : " - ";
    }

    public String getPhone() {
        return (phone!=null)? phone : " - ";
    }

    public String getDistrict() {
        return (district != null)? district : " - ";
    }

    public String getAccountCust() {
        return (accountCust != null)? accountCust : " - ";
    }

    public Customer(String iNN,
                    String customer,
                    boolean customerSign,
                    String addressCust,
                    String chief,
                    String bankCustomer,
                    String phone,
                    String district,
                    String accountCust) {
        this.iNN = iNN;
        this.customer = customer;
        this.customerSign = customerSign;
        this.addressCust = addressCust;
        this.chief = chief;
        this.bankCustomer = bankCustomer;
        this.phone = phone;
        this.district = district;
        this.accountCust = accountCust;
    }


}
