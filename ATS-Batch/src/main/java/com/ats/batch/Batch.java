package com.ats.batch;


public interface Batch {
	
	public Integer preProcesser();
	public void start();
	public void proces();
	public void postProcesser();

}
