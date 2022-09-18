package com.mycompany.invoise.core.controller.scan;

import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;

//@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface {
    private InvoiceServiceInterface invoiceService;
    @Override
    public String createInvoice(Invoice invoice) {
        System.out.println("Usage of scanner");
        invoice = new Invoice();
        invoice.setCustomerName("Virgic Galactic");
        invoiceService.createInvoice(invoice);
        return null;
    }

    @Override
    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }
}
