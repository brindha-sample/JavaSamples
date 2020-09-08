package com.custom;

public class TopicIterator implements Iterator{

	private int position;
	Topic[] topics;
	
	public TopicIterator(Topic[] topics){
		 position=0;
		 this.topics=topics;
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (position >= topics.length){
			return false;
		}
		return true;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return topics[position++];
	}

	@Override
	public Object currentElement() {
		// TODO Auto-generated method stub
		return topics[position];
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		position=0;
		
	}

}
