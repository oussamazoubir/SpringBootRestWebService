package com.user.management.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {

	@SuppressWarnings("unused")
	private Long resourceId;

	public ResourceNotFoundException(Long resourceId, String message) {
		super(message);
		this.resourceId = resourceId;
	}
}
