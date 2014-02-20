package com.gatf.executor.postman;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.gatf.executor.core.TestCase;

@JsonAutoDetect(getterVisibility=Visibility.NONE, fieldVisibility=Visibility.ANY, isGetterVisibility=Visibility.NONE)
@JsonSerialize(include=Inclusion.NON_NULL)
public class PostmanCollection {

	private String id = UUID.randomUUID().toString();
	
	private String name;
	
	private String description;
	
	private Date timestamp = new Date();
	
	private boolean synced = false;
	
	private List<String> order = new ArrayList<String>();
	
	private List<String> folders = new ArrayList<String>();
	
	private List<PostmanTestCase> requests = new ArrayList<PostmanTestCase>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isSynced() {
		return synced;
	}

	public void setSynced(boolean synced) {
		this.synced = synced;
	}

	public List<String> getOrder() {
		return order;
	}

	public void setOrder(List<String> order) {
		this.order = order;
	}

	public List<String> getFolders() {
		return folders;
	}

	public void setFolders(List<String> folders) {
		this.folders = folders;
	}

	public List<PostmanTestCase> getRequests() {
		return requests;
	}

	public void setRequests(List<PostmanTestCase> requests) {
		this.requests = requests;
	}
	
	public void addTestCase(TestCase testCase, int version)
	{
		if(testCase!=null)
		{
			PostmanTestCase postmanTestCase = new PostmanTestCase(testCase);
			postmanTestCase.setCollectionId(id);
			postmanTestCase.setVersion(version);
			requests.add(postmanTestCase);
			getOrder().add(postmanTestCase.getId());
		}
	}
}