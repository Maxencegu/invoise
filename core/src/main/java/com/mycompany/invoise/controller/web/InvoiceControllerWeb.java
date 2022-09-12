package com.mycompany.invoise.controller.web;

import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class InvoiceControllerWeb implements InvoiceControllerInterface {
    @Autowired
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

    @RequestMapping("/invoice-home")
    public @ModelAttribute("invoices") List<Invoice> displayHome(/*HttpServletRequest request*/) {
        System.out.println("La méthode displayHome a bien été invoquée.");
        List<Invoice> invoices = invoiceService.getInvoices();
        //request.setAttribute("invoices", invoices);
        return invoices;
    }
}
