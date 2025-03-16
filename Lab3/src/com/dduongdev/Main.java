package com.dduongdev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dduongdev.entities.Document;
import com.dduongdev.entities.DocxDocument;
import com.dduongdev.entities.PdfDocument;
import com.dduongdev.entities.PdfToDocxAdapter;
import com.dduongdev.entities.TxtDocument;
import com.dduongdev.storages.CloudStorage;
import com.dduongdev.storages.DropboxStorage;
import com.dduongdev.storages.GoogleDriveStorage;
import com.dduongdev.storages.LocalStorage;

public class Main {
	public static void main(String[] args) {
		Document pdf = new PdfDocument("Microservices", "Microservices là một kiến trúc phần mềm...");
        Document docx = new DocxDocument("Clean Architecture", "Clean Architecture giúp tổ chức code tốt hơn...");
        Document txt = new TxtDocument("Design Patterns", "Adapter và Bridge là hai mẫu thiết kế quan trọng...");
        Document txt2 = new TxtDocument("Design Patterns", "Singleton và Observer là hai mẫu thiết kế quan trọng...");
        Document adaptedPdf = new PdfToDocxAdapter(new PdfDocument("Java Concurrency", "Lập trình đa luồng trong Java giúp tối ưu hiệu suất..."));
        
        CloudStorage googleDrive = new GoogleDriveStorage();
        CloudStorage dropbox = new DropboxStorage();
        CloudStorage local = new LocalStorage();
        
        Map<String, DocumentManager> managers = new HashMap<String, DocumentManager>();
        managers.put("GoogleDrive", new DocumentManager(googleDrive));
        managers.put("Dropbox", new DocumentManager(dropbox));
        managers.put("Local", new DocumentManager(local));
        
        
        DocumentManager manager = managers.get("GoogleDrive");
        manager.save(pdf);
        manager.save(docx);
        
        manager = managers.get("Dropbox");
        manager.save(txt);
        
        manager = managers.get("Local");
        manager.save(adaptedPdf);
        manager.save(txt2);
        
        System.out.println();
        
        List<Document> searchResult = findByName("Design Patterns", managers);
        System.out.println("Search result: ");
        for (Document document : searchResult) {
        	document.display();
        	System.out.println();
        }
	}
	
	public static List<Document> findByName(String name, Map<String, DocumentManager> managers) {
		List<Document> result = new ArrayList<Document>();
		System.out.println("Searching...");
		for (DocumentManager manager : managers.values()) {
			result.addAll(manager.findByName(name));
		}
		return result;
	}
}
