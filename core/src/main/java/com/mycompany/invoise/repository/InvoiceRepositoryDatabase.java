package com.mycompany.invoise.repository;

import com.mycompany.invoise.entity.Invoice;

public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {

    public void create(Invoice invoice) {
        // JDBC connection
        System.out.println("JDBC : Invoice added with the number " + invoice.getNumber() + " for " + invoice.getCustomerName());
    }
}
