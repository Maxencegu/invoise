package com.mycompany.invoise.invoiseweb.controller;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import com.mycompany.invoise.invoiseweb.form.InvoiceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb {
    @Autowired
    private InvoiceServiceInterface invoiceService;

    @PostMapping()
    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult results) {
        if(results.hasErrors()){
            return "invoice-create-form";
        }
        Invoice invoice = new Invoice();
        invoice.setOrderNumber(invoiceForm.getOrderNumber());
        invoice.setCustomerName(invoiceForm.getCustomerName());
        invoiceService.createInvoice(invoice);
        return "invoice-created";
    }

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
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice) {
        return "invoice-create-form";
    }
}
