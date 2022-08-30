package com.mycompany.invoise.controller;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.service.InvoiceServiceInterface;

public class InvoiceControllerWeb implements InvoiceControllerInterface {
    private InvoiceServiceInterface invoiceService;

    @Override
    public void createInvoice() {
        Invoice invoice = new Invoice();
        invoice.setCustomerName("Tesla");

        invoiceService.createInvoice(invoice);
    }

    @Override
    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }
}
