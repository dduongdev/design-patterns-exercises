package com.dduongdev.storages;

import java.util.List;

import com.dduongdev.entities.Document;

public interface CloudStorage {
	List<Document> findByName(String name);
	void save(Document document);
}
