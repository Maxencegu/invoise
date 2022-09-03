package com.mycompany.invoise.controller.scan;

import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import org.springframework.stereotype.Controller;

//@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface {
    private InvoiceServiceInterface invoiceService;
    @Override
    public void createInvoice() {
        System.out.println("Usage of scanner");
        Invoice invoice = new Invoice();
        invoice.setCustomerName("Virgic Galactic");
        invoiceService.createInvoice(invoice);
    }

    @Override
    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }
}
