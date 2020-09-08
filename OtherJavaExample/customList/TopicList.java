package com.custom;

public class TopicList implements List{

	Topic[] topics;
	
	public TopicList(Topic[] topics){
		this.topics=topics;
	}
	@Override
	public TopicIterator iterate() {
		// TODO Auto-generated method stub
		return new TopicIterator(topics);
	}

}
