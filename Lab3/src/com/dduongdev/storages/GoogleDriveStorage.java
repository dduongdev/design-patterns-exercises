package com.dduongdev.storages;

import java.util.ArrayList;
import java.util.List;

import com.dduongdev.entities.Document;

public class GoogleDriveStorage implements CloudStorage {
	private List<Document> documents;

	public GoogleDriveStorage() {
		documents = new ArrayList<Document>();
	}

	@Override
	public List<Document> findByName(String name) {
		return documents.stream()
				.filter(doc -> doc.getName()
						.toLowerCase()
						.contains(name.toLowerCase())).toList();
	}

	@Override
	public void save(Document document) {
		documents.add(document);
		System.out.println("Storing document '" + document.getName() + "' in Google Drive.");
	}
}
