package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceController;
import com.mycompany.invoise.controller.InvoiceControllerChambouleToutMagasin2;
import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.controller.InvoiceControllerMichel;
import com.mycompany.invoise.repository.InvoiceRepository;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.repository.InvoiceRepositoryMichel;
import com.mycompany.invoise.service.InvoiceService;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import com.mycompany.invoise.service.InvoiceServiceMichel;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        InvoiceControllerInterface invoiceController;
        InvoiceServiceInterface invoiceService;
        InvoiceRepositoryInterface invoiceRepository;

        System.out.println("Dans quelle configuration êtes-vous ?");
        Scanner sc = new Scanner(System.in);
        int configuration = sc.nextInt();
        if(configuration == 1) {
            invoiceController = new InvoiceController();
            invoiceService = new InvoiceService();
            invoiceRepository = new InvoiceRepository();
            invoiceController.setInvoiceService(invoiceService);
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();
        } else if(configuration == 2) {
            invoiceController = new InvoiceControllerMichel();
            invoiceService = new InvoiceServiceMichel();
            invoiceRepository = new InvoiceRepositoryMichel();
            invoiceController.setInvoiceService(invoiceService);
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();
        } else if(configuration == 3) {
            invoiceController = new InvoiceControllerChambouleToutMagasin2();
            invoiceService = new InvoiceService();
            invoiceRepository = new InvoiceRepositoryMichel();
            invoiceController.setInvoiceService(invoiceService);
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();
        }
    }
}
