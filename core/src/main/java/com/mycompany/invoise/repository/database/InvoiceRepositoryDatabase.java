package com.mycompany.invoise.repository.database;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {

    public void create(Invoice invoice) {
        // JDBC connection
        System.out.println("JDBC : Invoice added with the number " + invoice.getNumber() + " for " + invoice.getCustomerName());
    }
}
