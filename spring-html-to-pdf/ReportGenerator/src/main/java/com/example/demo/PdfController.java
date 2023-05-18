package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pdf")
public class PdfController {
    @Autowired
    private PdfGenerator pdfGenerator;

    @GetMapping(value = "/generate")
    public @ResponseBody String generatePdf(@RequestParam("htmlFileName") String htmlFileName,
                                             @RequestParam("pdfFileName") String pdfFileName) throws Exception {
        pdfGenerator.generatePdfFromHtml(htmlFileName, pdfFileName);
        return "PDF file generated successfully!";
    }
}