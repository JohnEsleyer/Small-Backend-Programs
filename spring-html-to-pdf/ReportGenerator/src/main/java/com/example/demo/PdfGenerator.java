package com.example.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Component
public class PdfGenerator {
    public void generatePdfFromHtml(String htmlFileName, String pdfFileName) throws Exception {
        String htmlFile = new ClassPathResource("templates/" + htmlFileName).getFile().getAbsolutePath();
        String outputFile = pdfFileName;
        OutputStream os = new FileOutputStream(outputFile);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(new File(htmlFile));
        renderer.layout();
        renderer.createPDF(os);

        os.close();
    }
}