package com.dduongdev;

import java.util.List;

import com.dduongdev.entities.Document;
import com.dduongdev.storages.CloudStorage;

public class DocumentManager {
	private CloudStorage storage;
	
	public DocumentManager(CloudStorage storage) {
		this.storage = storage;
	}
	
	public void save(Document document) {
		storage.save(document);
	}
	
	public List<Document> findByName(String name) {
		return storage.findByName(name);
	}
}
