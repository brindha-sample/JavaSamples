package com.custom;

public class CustomList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Topic[] topic=new Topic[5];
		topic[0]=new Topic("aaa");
		topic[1]=new Topic("bbb");
		topic[2]=new Topic("ccc");
		topic[3]=new Topic("ddd");
		topic[4]=new Topic("eee");
		
		List<Topic> topicLst = new TopicList(topic);
		Iterator<Topic> itr= topicLst.iterate();
		while(itr.hasNext()){
			System.out.println(itr.next().getName());
		}
	}

}
