package com.dduongdev.entities;

public class PdfToDocxAdapter implements Document {
	private PdfDocument pdfDocument;

    public PdfToDocxAdapter(PdfDocument pdfDocument) {
        this.pdfDocument = pdfDocument;
    }

    @Override
    public void display() {
        System.out.println("Converting PDF to DOCX...");
        pdfDocument.display();
    }

	@Override
	public String getName() {
		return pdfDocument.getName();
	}

}
