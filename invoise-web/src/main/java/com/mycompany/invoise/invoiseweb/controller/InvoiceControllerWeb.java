package com.mycompany.invoise.invoiseweb.controller;

import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb implements InvoiceControllerInterface {
    @Autowired
    private InvoiceServiceInterface invoiceService;

    @Override
    @PostMapping()
    public String createInvoice(@ModelAttribute Invoice invoice) {
        invoiceService.createInvoice(invoice);
        return "invoice-created";
    }

    @Override
    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/home")
    public String displayHome(Model model) {
        System.out.println("La méthode displayHome a bien été invoquée.");
        model.addAttribute("invoices", invoiceService.getInvoices());
        return "invoice-home";
    }

    @GetMapping("/{id}")
    public String displayInvoice(@PathVariable("id") String number, Model model) {
        System.out.println("La méthode displayInvoice a bien été invoquée.");
        model.addAttribute("invoice", invoiceService.getInvoiceByNumber(number));
        return "invoice-details";
    }

    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute Invoice invoice) {
        return "invoice-create-form";
    }
}
