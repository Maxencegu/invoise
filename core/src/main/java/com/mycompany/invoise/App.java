package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quelle est la classe du controller ?");
        String controllerClass = sc.nextLine();
        System.out.println("Quelle est la classe du service ?");
        String serviceClass = sc.nextLine();
        System.out.println("Quelle est la classe du repository ?");
        String repositoryClass = sc.nextLine();

        InvoiceControllerInterface invoiceController;
        InvoiceServiceInterface invoiceService;
        InvoiceRepositoryInterface invoiceRepository;
        try {
            invoiceController = (InvoiceControllerInterface)Class.forName(controllerClass).getDeclaredConstructor().newInstance();
            invoiceService = (InvoiceServiceInterface)Class.forName(serviceClass).getDeclaredConstructor().newInstance();
            invoiceRepository = (InvoiceRepositoryInterface)Class.forName(repositoryClass).getDeclaredConstructor().newInstance();

            invoiceController.setInvoiceService(invoiceService);
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
