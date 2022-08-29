package com.mycompany.invoise.controller;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.service.InvoiceServiceInterface;

import java.util.Scanner;

public class InvoiceControllerMichel implements InvoiceControllerInterface {
    private InvoiceServiceInterface invoiceService;

    public void createInvoice() {
        Invoice invoice = new Invoice();
        invoice.setCustomerName("Tesla");

        invoiceService.createInvoice(invoice);
    }
}
